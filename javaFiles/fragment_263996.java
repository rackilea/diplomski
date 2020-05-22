public void deepClone() {
    Map<EntityBase,EntityBase> alreadyCloned = 
        new IdentityHashMap<EntityBase,EntityBase>();
    return deepClone(this,alreadyCloned);
}

private static EntityBase deepClone(EntityBase entity, 
                                    Map<EntityBase,EntityBase> alreadyCloned) {
    EntityBase clone = alreadyCloned.get(entity);
    if( clone != null ) {
        return alreadyClonedEntity;
    }
    clone = newInstance(entity.getClass);
    alreadyCloned.put(this,clone);
    // fill clone's attributes from original entity. Call
    // deepClone(entity,alreadyCloned) 
    // recursively for each entity valued object.
    ...
}