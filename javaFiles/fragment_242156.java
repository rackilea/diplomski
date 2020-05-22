public static void main(String[] args) {
    final Map<String, List<Integer>> map = new HashMap<>();
    map.put("k1", Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
    map.put("k2", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
    map.put("k3", Arrays.asList(new Integer[]{1, 2, 3}));
    System.out.println(getMapSortedByListSize(map));
}

public static <K, V> Map<K, List<V>> getMapSortedByListSize(final Map<K, List<V>> map) {
    return map.entrySet().stream()
            .sorted((e1, e2) -> e1.getValue().size() - e2.getValue().size())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
}