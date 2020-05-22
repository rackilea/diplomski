public static <K,V> Map<K,V> sorted(Map<K,V> map, Comparator<Map.Entry<K, V>> comparator){
    return map.entrySet()
       .stream()
       .sorted(comparator)
       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
}