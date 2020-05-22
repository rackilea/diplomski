public static <T> void iterateOverSupertypes(T input) {
    Class<?> clazz = input.getClass();
    while (clazz.getSuperclass() != null) {
        clazz = clazz.getSuperclass();
    }
}