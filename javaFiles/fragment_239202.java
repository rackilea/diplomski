public static <T extends Enum<T>> void some_method(Class<T> clazz, String name) {
    try {
        T foundEnum = Enum.valueOf(clazz, name);
        // name matches to one of enum values, do something with it
    } catch (IllegalArgumentException e) {
        // name doesn't matches to any of enum values
    }
}