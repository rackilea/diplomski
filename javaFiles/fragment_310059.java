public static <K> List<K> getKeys(List<Map.Entry<K,?>> entryList) {
    return entryList.stream().map(Entry::getKey).collect(Collectors.toList());
}

public static <V> List<V> getValues(List<Map.Entry<?,V>> entryList) {
    return entryList.stream().map(Entry::getValue).collect(Collectors.toList());
}