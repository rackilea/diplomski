public static <K,V> Multimap<K,V> toMultiMap(Map<K,? extends Collection<V>> m) {

    LinkedListMultimap<K, V> multimap = LinkedListMultimap.create();

    for (Entry<K, ? extends Collection<V>> e : m.entrySet())
        multimap.putAll(e.getKey(), e.getValue());

    return multimap;
}