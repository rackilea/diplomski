String protectedEntityName = FooEntity.class.getName();
SessionFactoryImpl sessionFactory = (SessionFactoryImpl) session.getSessionFactory();

for (EntityPersister entityPersister : sessionFactory.getEntityPersisters().values()) {
    for (int i = 0; i < entityPersister.getPropertyTypes().length; i++) {
        Type type = entityPersister.getPropertyTypes()[i];
        EntityType entityType = null;
        if (type.isCollectionType()) {
            CollectionType collectionType = (CollectionType) type;
            Type elementType = sessionFactory.getCollectionPersister(collectionType.getRole()).getElementType();
            if (elementType.isEntityType()) {
                entityType = (EntityType) elementType; 
            }
        } else if (type.isEntityType()) {
            entityType = (EntityType) type;
        }
        if (entityType != null && entityType.getName().equals(protectedEntityName)) {
            if (entityPersister.getPropertyCascadeStyles()[i].doCascade(CascadingAction.DELETE)) {
                // Exception can be thrown from here.
                System.out.println("Found! Class: " + entityPersister.getEntityName() + "; property: " + entityPersister.getPropertyNames()[i]);
            }
        }
    }
}