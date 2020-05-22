class EnvironmentHolder<V> {
    private final Class<V> clazz;

    EnvironmentHolder(Class<V> clazz) {
        this.clazz = clazz;
    }

    public void importEnvironment(Class<?> aClass) {
        for (Field field : aClass.getFields()) {
            if (clazz.isAssignableFrom(field.getType())) {
                // ...
            }
        }
    }
}