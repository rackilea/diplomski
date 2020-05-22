public Entity save(Entity entity, boolean rollback) {
    // look for a match, you'll have to implement your own method here
    Entity match = getEntityByValue("column_name", entity.getMergeColumn());

    if (match != null) {
        // copy the primary key
        entity.setId(match.getId());
    }

    // save the entity
    save(entity, rollback);
}