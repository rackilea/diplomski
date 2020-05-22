public static <T> T evilMethod(Class<T> clazz, Object obj) {
    try {
        return clazz.cast(obj);
    } catch (ClassCastException exc) {
        return null;
    }
}