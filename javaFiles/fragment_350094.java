public static <T, K, V> Collector<T, ?, ImmutableMultimap<K, V>> toImmutableListMultimap(
        Function<? super T, ? extends K> keyMapper,
        Function<? super T, ? extends V> valueMapper) {

    Supplier<ImmutableMultimap.Builder<K, V>> supplier = ImmutableListMultimap.Builder::new;

    BiConsumer<ImmutableMultimap.Builder<K, V>, T> accumulator = (b, t) -> b
            .put(keyMapper.apply(t), valueMapper.apply(t));

    BinaryOperator<ImmutableMultimap.Builder<K, V>> combiner = (l, r) -> l.putAll(r.build());

    Function<ImmutableMultimap.Builder<K, V>, ImmutableMultimap<K, V>> finisher = ImmutableMultimap.Builder::build;

    return Collector.of(supplier, accumulator, combiner, finisher);
}