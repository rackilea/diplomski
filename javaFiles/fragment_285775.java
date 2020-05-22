class MapBuilder<K, V> {

    private List<Map.Entry<K, V>> entries;
    private BiFunction<K, V, Map.Entry<K, V>> function;

    public MapBuilder() {
        entries = new ArrayList<>();
    }

    public MapBuilder(BiFunction<K, V, Map.Entry<K, V>> function) {
        this();
        this.function = function;
    }

    public MapBuilder<K, V> with(K key, V value) {
        entries.add(function.apply(key, value));

        return this;
    }

    public Map<K, V> build(Supplier<Map<K, V>> mapSupplier) { ... }

}