public static <T> Stream<T> concat(Stream<? extends T> lhs, Stream<? extends T> rhs) {
    return Stream.concat(lhs, rhs);
}
public static <T> Stream<T> concat(Stream<? extends T> lhs, T rhs) {
    return Stream.concat(lhs, Stream.of(rhs));
}