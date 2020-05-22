public static <T extends Enum<T>> boolean contains(Class<T> clazz, String name) {
    try {
        Enum.valueOf(clazz, name);
    } catch (IllegalArgumentException e) {
        return false;
    }
    return true;
}