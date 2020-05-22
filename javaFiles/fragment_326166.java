static class Dated<V> {
    public final LocalDate date = LocalDate.now();
    public final V value;
    public Dated(V value) {
        this.value = value;
    }
}

Map<K, Dated<V>> map = new LinkedHashMap<>();

void insert(K key, V value) {
    Dated<V> datedValue = new Dated<>(value);
    LocalDate earliest = datedValue.date.minusDays(14);

    Iterator<Map.Entry<K, Dated<V>> it = map.entries().iterator();
    while (it.hasNext() && it.next().getValue().date.isBefore(earliest)) {
         it.remove();
    }

    map.remove(key); // So at the end of the linked list.
    map.put(key, datedValue);
}