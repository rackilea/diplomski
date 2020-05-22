public Set<K> removeEntries(Map<K, ?> from) {
    Set<K> result = keysToRemove.stream()
        .filter(from.keySet()::contains)
        .collect(Collectors.toSet());
    from.keySet().removeAll(result);
    return result;
}