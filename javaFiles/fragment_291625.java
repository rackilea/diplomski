Map<String, ClassMetadata>  map = (Map<String, ClassMetadata>) sessionFactory.getAllClassMetadata();
    for(String entityName : map.keySet()){
        SessionFactoryImpl sfImpl = (SessionFactoryImpl) sessionFactory;
        String tableName = ((AbstractEntityPersister)sfImpl.getEntityPersister(entityName)).getTableName();
        System.out.println(entityName + "\t" + tableName);
    }