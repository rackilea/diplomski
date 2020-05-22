public Set<K> removeEntries(Map<K, ?> from) {
    Set<K> fromKeys = from.keySet();
    Set<K> removedKeys = new HashSet<>();
    for(K keyToRemove : keysToRemove)
        if(fromKeys.remove(keyToRemove)) removedKeys.add(keyToRemove);
    return removedKeys;
}