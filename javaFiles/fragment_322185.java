class HashTable<K, V> implements HashTableInterface<K, V> {

    private class TableEntry<K, V> implements Entry<K, V> {
    }
    private final List<Entry<K, V>> entries = new LinkedList<>();

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return entries.iterator();
    }
}