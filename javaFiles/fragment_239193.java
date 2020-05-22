static <K, V> void justPut(ChronicleMap<K, V> map, K key, V value) {
    try (ExternalMapQueryContext<K, V, ?> c = map.queryContext(key)) {
        c.updateLock().lock();
        MapEntry<K, V> entry = c.entry();
        if (entry != null) {
            c.replaceValue(entry, value);
        } else {
            c.insert(c.absentEntry(), value);
        }
    }
}