ClassMetadata hibernateMetadata = sessionFactory.getClassMetadata("com.mypackage.Project ");
if (hibernateMetadata == null){
    return;
}

if (hibernateMetadata instanceof AbstractEntityPersister) {
    AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;

    for (Method method : persister.getClass().getSuperclass().getDeclaredMethods()) {
        if (method.getName().equalsIgnoreCase("getSQLInsertStrings")) {
            ReflectionUtils.makeAccessible(method);
            Object insertQueries = ReflectionUtils.invokeMethod(method, persister);

            for (String queryText : (String []) insertQueries) {
                System.out.println(queryText);
            }
        }

        if (method.getName().equalsIgnoreCase("getSQLUpdateStrings")) {
            ReflectionUtils.makeAccessible(method);
            Object insertQueries = ReflectionUtils.invokeMethod(method, persister);

            for (String queryText : (String []) insertQueries) {
                System.out.println(queryText);
            }
        }
    }
}