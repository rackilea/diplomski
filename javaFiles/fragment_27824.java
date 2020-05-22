public Set<K> removeEntries(Map<K, ?> from) {
    Set<K> fromKeys = from.keySet(), removedKeys = new HashSet<>(keysToRemove);
    removedKeys.retainAll(fromKeys);
    fromKeys.removeAll(removedKeys);
    return removedKeys;
}