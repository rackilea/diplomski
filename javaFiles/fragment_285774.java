class MapBuilder<K, V> {

    private List<Map.Entry<K, V>> entries = new ArrayList<>();

    public MapBuilder<K, V> with(K key, V value) {
        entries.add(new AbstractMap.SimpleImmutableEntry<>(key, value));

        return this;
    }

    public Map<K, V> build(Supplier<Map<K, V>> mapSupplier) {
        return entries.stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (k1, k2) -> k1,
                mapSupplier
                )
        );
    }

}