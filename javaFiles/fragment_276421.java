public enum ValueType {
    STRING(String.class), INTEGER(Integer.class), BOOLEAN(Boolean.class), FLOAT(Float.class);

    private Class<?> clazz;

    ValueType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean isInstance(Object obj) {
        return clazz.isInstance(obj);
    }
}