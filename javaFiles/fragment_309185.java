public static void main(final String[] args) throws Exception {
    final Map<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);
    final BiFunction<String, Integer, Integer> remapper = (k, v) -> v == null ? 42 : v + 41;
    map.compute("A", remapper);
}