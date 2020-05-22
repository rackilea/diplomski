public static <T> Collector<T, ?, Integer> summingInt(ToIntFunction<? super T> mapper) {
    return new CollectorImpl<>(
            () -> new int[1],
            (a, t) -> { a[0] += mapper.applyAsInt(t); },
            (a, b) -> { a[0] += b[0]; return a; },
            a -> a[0], Collections.emptySet());
}