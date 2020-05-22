public static <T extends Enum<T>> void some_method(Class<T> clazz, String name) {
    for (T each : clazz.getEnumConstants()) {
        if (each.name().equals(name)) {
            // name matches to one of enum values, do something with it
        }
    }
    // name doesn't matches to any of enum values
}