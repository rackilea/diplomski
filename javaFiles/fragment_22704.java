interface Collector<T, R> {
    Supplier<Object> supplier();
    BiConsumer<Object, T> accumulator();
    BiFunction<Object, Object, Object> combiner();
    Function<Object, R> finisher();
}

static <T> Collector<T, List<T>> toList() {
    return Collector.of(
        ArrayList::new,
        (obj, elem) -> ((List<T>) obj).add(elem),
        (a, b) -> {
            ((List<T>) a).addAll((List<T>) b);
            return a;
        },
        obj -> (List<T>) obj);
}