public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(
        Function<? super T, ? extends K> keyMapper,
        Function<? super T, ? extends V> valueMapper) {

    Supplier<ImmutableListMultimap.Builder<K, V>> supplier = ImmutableListMultimap.Builder::new;

    BiConsumer<ImmutableListMultimap.Builder<K, V>, T> accumulator = (b, t) -> b
            .put(keyMapper.apply(t), valueMapper.apply(t));

    BinaryOperator<ImmutableListMultimap.Builder<K, V>> combiner = (l, r) -> { 
        final ImmutableListMultimap<K, V> rightMap = r.build();
        rightMap.keySet().stream().forEach(k -> l.putAll(k, rightMap.get(k)));
        return l;
    };

    Function<ImmutableListMultimap.Builder<K, V>, ImmutableListMultimap<K, V>> finisher = ImmutableListMultimap.Builder::build;

    return Collector.of(supplier, accumulator, combiner, finisher);
}