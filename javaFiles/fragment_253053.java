private <K, V> List<Map.Entry<K,V>> getTop(Map<K,V> map, Comparator<V> cmp, int quantity) {
    return map.entrySet().stream()
           .sorted((a,b) -> cmp.compare(b,a))
           .limit(quantity)
           .collect(Collectors.toList());
}