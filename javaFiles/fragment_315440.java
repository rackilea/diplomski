public static <T> T[][] createArrays(Class<T> clazz, T... items) {
    Stream<Stream<T>> streams = EnumPerm.of(items);
    T[] template = Arrays.copyOf(items, 0);
    return streams
        .map(s -> s.toArray(len -> Arrays.copyOf(template, len)))
        .toArray(len -> (T[][])Array.newInstance(template.getClass(), len));
}