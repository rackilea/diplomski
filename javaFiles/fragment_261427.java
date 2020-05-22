@SafeVarargs
public static <T> Stream<T> filter(Stream<T> source, Predicate<T>... predicates) {
    return source.filter(
        Arrays.stream(predicates).reduce(predicates[0], Predicate::and));
}
public static <T> Stream<T> filter(Stream<T> source, Predicate<T> predicate) {
    return source.filter(predicate);
}