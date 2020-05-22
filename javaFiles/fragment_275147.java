@SqlResultSetMapping(name = "MyNativeQuery",
    entities = {
        @EntityResult(entityClass = Entity1.class),
        @EntityResult(entityClass = Entity2.class),
        @EntityResult(entityClass = Entity3.class),
        @EntityResult(entityClass = Entity4.class),
        @EntityResult(entityClass = Entity5.class),
        @EntityResult(entityClass = Entity6.class),
        @EntityResult(entityClass = Entity7.class)
    }
)