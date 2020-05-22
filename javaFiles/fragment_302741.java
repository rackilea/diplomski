public <K, V> Map<K, V> filter(Map<K, V> map, Predicate<Map.Entry<K, V>> filter) {
    return map.entrySet()
            .stream()
            // Filter out the unwanted ones.
            .filter(filter)
            // Fold back into a new Map.
            .collect(Collectors.toMap(
                            (Map.Entry<K, V> e) -> e.getKey(),
                            (Map.Entry<K, V> e) -> e.getValue()));
}

public Map<Integer, String> removeRangeWithStream(Map<Integer, String> map, String from, String to) {
    return filter(map,
            (Map.Entry<Integer, String> e) -> e.getValue().compareTo(from) <= 0 || e.getValue().compareTo(to) >= 0);
}