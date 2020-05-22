public static Field getField(final Class<?> toReflectOn, final String fieldName) throws NoSuchFieldException {
    try {
        return toReflectOn.getField(fieldName);
    } catch (NoSuchFieldException ex) {
        if (toReflectOn.getSuperclass() != null) {
            return getField(toReflectOn.getSuperclass(), fieldName);
        }
        throw ex;
    }
}