private class Entry<K, V> {
    private K key;
    private V value;
//but here K and V are being hidden.
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}