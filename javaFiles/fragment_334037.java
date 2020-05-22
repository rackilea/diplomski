static <T1, T2, R> Function<T1, Stream<R>> crossWith(
         Supplier<? extends Stream<T2>> otherSup, 
         BiFunction<? super T1, ? super T2, ? extends R> combiner
) {
    return t1 -> otherSup.get().map(t2 -> combiner.apply(t1, t2));
}