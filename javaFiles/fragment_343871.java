static class MapWithDefault<K, V> extends TreeMap<K, V> {
    private V dflt;

    @Override
    public V get(Object key) {
        V v = super.get(key);
        return v == null ? dflt : v;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            V was = dflt;
            dflt = value;
            return was;
        }
        return super.put(key, value);
    }

    public void setDflt(V dflt) {
        this.dflt = dflt;
    }
}