public static <T> List<T> filterInstancesOf(List<?> original, Class<T> cls) {
    List<T> rv = new ArrayList<>();
    for (Object o: original) {
        if (cls.isInstance(o)) {
            rv.add(cls.cast(o));
        }
    }
    return rv;
}