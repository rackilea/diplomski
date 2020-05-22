class CopyMap<K, V extends Copyable<V>> extends HashMap<K, V> {
    @Override
    public V get(Object key) {
        return super.get(key).getCopy();
    }
}