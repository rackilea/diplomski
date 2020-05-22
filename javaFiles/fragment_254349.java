public static <K,V> boolean replaceValue(Multimap<K,V> map, K key, V oldValue, V newValue) {
    if (map.remove(key, oldValue)) {
        map.put(key, newValue);
        return true;
    }
    return false;
}