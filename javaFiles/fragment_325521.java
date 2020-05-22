public static <T, U, A, R>
    Collector<T, ?, R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper,
                                   Collector<? super U, A, R> downstream) {
        BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
        return Collector.of(downstream.supplier(),
                            (r, t) -> mapper.apply(t).sequential().forEach(u -> downstreamAccumulator.accept(r, u)),
                            downstream.combiner(),
                            downstream.finisher(),
                            downstream.characteristics().stream().toArray(Collector.Characteristics[]::new));
    }