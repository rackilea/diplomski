public static <T> T[][] createArrays(Class<T> clazz, T... items) {
    Stream<Stream<T>> streams = EnumPerm.of(items);
    return streams
        .map(s -> s.toArray(len -> (T[])Array.newInstance(clazz, len)))
        .toArray(len -> (T[][])Array.newInstance(clazz, len, 0));
}