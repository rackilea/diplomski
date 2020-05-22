class Example<E extends Entity> {
    private List<E> listedEntities = new ArrayList<>();
    private Class<E> entityClass;

    Example(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    void method()
    throws IllegalAccessException, InstantiationException {
        E newEntity = entityClass.newInstance();
        listedEntities.add(newEntity);
    }
}