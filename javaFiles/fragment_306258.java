<D, K> Map<D, List<K>> swap(Map<K, List<D>> map) {
  return map.entrySet().stream()
                       .flatMap(e -> e.getValue().stream()
                                                 .map(v -> new SimpleEntry<>(v, e.getKey())))
     .collect(Collectors.groupingBy(Entry::getKey, 
                                    Collectors.mapping(Entry::getValue,
                                                       Collectors.toList())));
}