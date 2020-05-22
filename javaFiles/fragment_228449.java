public static <T> Collector<T, ?, Long> summingLong(ToLongFunction<? super T> mapper) 
{
    return new CollectorImpl<>(
        () -> new long[1],
        (a, t) -> { a[0] += mapper.applyAsLong(t); },
        (a, b) -> { a[0] += b[0]; return a; },
        a -> a[0], CH_NOID);
}