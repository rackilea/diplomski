public static void main(String[] args) {
    final Map<Integer, Double> map = new HashMap<Integer, Double>();
    map.put(1343, 0.521851);
    map.put(1950, -0.301208);
    map.put(3667, -0.0280762);
    map.put(3879, 0.154724);
    map.put(4124, 0.022583);
    Map<Integer, Double> sortedMap = sortMap(map);

    for (Map.Entry<Integer, Double> entry : sortedMap.entrySet()) {
        System.out.println(entry.getKey() + ", " + entry.getValue());
    }
}

public static Map<Integer, Double> sortMap(final Map<Integer, Double> map) {
    Map<Integer, Double> sortedMap = new TreeMap<Integer, Double>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    });
    sortedMap.putAll(map);
    return sortedMap;
}