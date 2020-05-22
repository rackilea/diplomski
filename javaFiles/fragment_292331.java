private static final String _SELECT_CROSS_JOIN_ENTITIES = 
            "SELECT new my.package.CrossJoinedFoo(a,b,c) FROM "
            + "EntityA a"
            + ", "
            + "EntityB b"
            + ", "
            + "EntityC c"
            + " WHERE (1=1) "
            + " AND " + "a.someValue = :someValue"
            + " AND " + "b.someValue = :someValue"
            + " AND " + "c.someValue = :someValue";

Query query = entityManager.createQuery(_SELECT_CROSS_JOIN_ENTITIES);
query.setParameter(":someValue", "foo");

List<CrossJoinedFoo> result = query.list();