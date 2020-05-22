public static void main(String[] args) {
    Map<String, Double> map = new LinkedHashMap<String, Double>();
    map.put("s",100.00);
    map.put("d",80.00);
    map.put("a",80.00);
    map.put("e",80.00);
    map.put("c", 50.00);
    map.put("w", 50.00);
    map.put("q", 20.00);

    Map<Double, List<String>> inverted = invertMap(map);
    List<Double> keys = new ArrayList<>(inverted.keySet());
    Collections.sort(keys, Comparator.reverseOrder());

    Map<String, Integer> result = new LinkedHashMap<>();

    int i = 1;
    for (Double key : keys) {
        for (String s : inverted.get(key))
            result.put(s, i);
        i++;
    }
    System.out.println(result);
}

static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
    Map<V, List<K>> result = new HashMap<>();
    for (K key : map.keySet()) {
        V val = map.get(key);
        if (!result.containsKey(val))
            result.put(val, new ArrayList<>());
        result.get(val).add(key);
    }
    return result;
}