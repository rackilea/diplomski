public static <K, V> Map.Entry<K, V> entry(K key, V value) {
    return new AbstractMap.SimpleImmutableEntry<>(key, value);
}

@SafeVarargs
public static <K, V> Map<K,V> mapOf(Map.Entry<? extends K, ? extends V>... entries) {
    return Stream.of(entries)
             .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}

@SafeVarargs
public static <K, V> ConcurrentMap<K,V> concurrentMapOf(
                                        Map.Entry<? extends K, ? extends V>... entries) {
    return Stream.of(entries)
             .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
}