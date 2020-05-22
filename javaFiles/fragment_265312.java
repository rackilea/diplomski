public <K extends Number & Comparable<K>, V extends Number> K findSmallestKey(Map<K, V> values, V searchItem) {
    // Grab the key set, and sort it.
    List<K> keys = new ArrayList<>(values.keySet());
    Collections.sort(keys);
    for(K key : keys) {
        if(values.get(key).doubleValue() == searchItem.doubleValue()) {
            return key;
        }
    }
    return null;
}