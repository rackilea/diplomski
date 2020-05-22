private static <T,A,R,S> Collector<T,?,S> combine(Collector<T,A,R> collector, Function<? super R, ? extends S> function) {
    return Collector.of(
        collector.supplier(),
        collector.accumulator(),
        collector.combiner(),
        collector.finisher().andThen(function));
}
public static <T> Collector<T,?,Stream<T>> concat(Stream<? extends T> other) {
    return combine(Collectors.toList(),
        list -> Stream.concat(list.stream(), other));
}
public static <T> Collector<T,?,Stream<T>> concat(T element) {
    return concat(Stream.of(element));
}