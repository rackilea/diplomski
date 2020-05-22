public static <T> Supplier<T> getter(Object obj, Class<T> fieldClass, Field f) {

    if (!fieldClass.isAssignableFrom(f.getType()))
        throw new RuntimeException("Field is not of expected type");

    return () -> {
        try {
            return (T) f.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    };
}