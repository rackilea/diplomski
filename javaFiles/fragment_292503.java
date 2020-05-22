public class MyPersister extends SingleTableEntityPersister {

    public MyPersister(PersistentClass persistentClass,
            EntityDataAccess cacheAccessStrategy,
            NaturalIdDataAccess naturalIdRegionAccessStrategy,
            PersisterCreationContext creationContext)
            throws HibernateException {
        super(modify(persistentClass), cacheAccessStrategy,
                naturalIdRegionAccessStrategy, creationContext);
    }

    private static PersistentClass modify(PersistentClass persistentClass) {
        SimpleValue value = (SimpleValue) persistentClass
                .getProperty("someField").getValue();
        value.setTypeName(MyType.class.getName());
        return persistentClass;
    }
}