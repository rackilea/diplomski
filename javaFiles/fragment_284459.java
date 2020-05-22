static <T,U,A,R> Collector<T,?,R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream) {
    BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
    return Collector.of(
            downstream.supplier(),
            (acc, t) -> {
                try (Stream<? extends U> stream = mapper.apply(t)) {
                    if (stream != null) {
                        stream.sequential().forEach(u -> downstreamAccumulator.accept(acc, u));
                    }
                }
            },
            downstream.combiner(),
            downstream.finisher(),
            downstream.characteristics().toArray(new Characteristics[downstream.characteristics().size()])
           );
}