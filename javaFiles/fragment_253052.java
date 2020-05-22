private <K, V extends Comparable<V>> List<Map.Entry<K,V>> getTop(Map<K,V> map, int quantity) {
    return map.entrySet().stream()
           .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
           .limit(quantity)
           .collect(Collectors.toList());
}