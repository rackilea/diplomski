public static <T, K> Collector<T, ?, Multimap<K, T>> toMultimapByKey(Function<? super T, ? extends Iterable<? extends K>> keysMapper) {
    return new MultimapCollector<>(keysMapper);
}

private static class MultimapCollector<T, K> implements Collector<T, ImmutableMultimap.Builder<K, T>, Multimap<K, T>> {
    private final Function<? super T, ? extends Iterable<? extends K>> keysMapper;

    private MultimapCollector(Function<? super T, ? extends Iterable<? extends K>> keysMapper) {
        this.keysMapper = keysMapper;
    }

    @Override
    public Supplier<ImmutableMultimap.Builder<K, T>> supplier() {
        return ImmutableMultimap::builder;
    }

    @Override
    public BiConsumer<ImmutableMultimap.Builder<K, T>, T> accumulator() {
        return (builder, value) -> keysMapper.apply(value).forEach(k -> builder.put(k, value));
    }

    @Override
    public BinaryOperator<ImmutableMultimap.Builder<K, T>> combiner() {
        return (b1, b2) -> b1.putAll(b2.build());
    }

    @Override
    public Function<ImmutableMultimap.Builder<K, T>, Multimap<K, T>> finisher() {
        return ImmutableMultimap.Builder<K, T>::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}