package io.quarkus.panache.rest.common;

import java.util.List;

import javax.ws.rs.core.Response;

/**
 * Base Panache CRUD resource interface.
 * Defines JAX-RS CRUD operations that will be implemented by the data store specific extensions such as Hibernate ORB or
 * MongoDB.
 * <p>
 * User shouldn't use this interface directly but rather its sub-interfaces defined by the data store specific extensions.
 *
 * @param <Entity> Entity type that is handled by this CRUD resource.
 * @param <ID> ID type of the entity.
 */
public interface PanacheCrudResource<Entity, ID> {

    /**
     * Return all entities as a JSON array.
     * Response content type: application/json.
     *
     * @return A response with a JSON array of all entities.
     */
    List<Entity> list();

    /**
     * Return an entity as a JSON object.
     * Response content type: application/json.
     *
     * @param id Entity identifier.
     * @return A response with a JSON object representing an entity.
     */
    Entity get(ID id);

    /**
     * Create a new entity from the provided JSON object.
     * Request body type: application/json.
     * Response content type: application/json.
     *
     * @param entity Entity to be created
     * @return A response with a JSON object representing an entity and a location header of the new entity.
     */
    Response add(Entity entity);

    /**
     * Update an existing entity or create a new one from the provided JSON object.
     * Request content type: application/json
     * Response content type: application/json
     *
     * @param id Entity identifier.
     * @param entity Entity to be updated or created.
     * @return A response with no-content status in case of the update.
     *         A response with a JSON object representing an entity and a location header in case of the create.
     */
    Response update(ID id, Entity entity);

    /**
     * Delete an entity.
     *
     * @param id Entity identifier.
     */
    void delete(ID id);
}
