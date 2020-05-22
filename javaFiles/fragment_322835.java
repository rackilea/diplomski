List<Map.Entry<Integer, Set<Integer>>> entries = new ArrayList<>(
            map.entrySet());
Collections.sort(entries,
        new Comparator<Map.Entry<Integer, Set<Integer>>>() {
            public int compare(Map.Entry<Integer, Set<Integer>> a,
                    Map.Entry<Integer, Set<Integer>> b) {
                return Integer.compare(
                          a.getValue().size(),
                          b.getValue().size());
            }
        });

Map<Integer, Set<Integer>> sortedMap = new LinkedHashMap<>();
for (Map.Entry<Integer, Set<Integer>> entry : entries) {
    sortedMap.put(entry.getKey(), entry.getValue());
}