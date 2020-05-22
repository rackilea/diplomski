public static <T, A, R> Collector<T, ?, R> filtering(
    Predicate<? super T> predicate, Collector<? super T, A, R> downstream) {

    BiConsumer<A, ? super T> accumulator = downstream.accumulator();
    return Collector.of(downstream.supplier(),
        (r, t) -> { if(predicate.test(t)) accumulator.accept(r, t); },
        downstream.combiner(), downstream.finisher(),
        downstream.characteristics().toArray(new Collector.Characteristics[0]));
}