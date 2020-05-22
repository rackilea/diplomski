public static <K1, K2, V> Map<K1, Map<K2, V>> deepCopy(
    Map<K1, Map<K2, V>> original){

    Map<K1, Map<K2, V>> copy = new HashMap<K1, Map<K2, V>>();
    for(Entry<K1, Map<K2, V>> entry : original.entrySet()){
        copy.put(entry.getKey(), new HashMap<K2, V>(entry.getValue()));
    }
    return copy;
}