static <K, V> void orderByValue(
        LinkedHashMap<K, V> m, Comparator<? super V> c) {
    List<Map.Entry<K, V>> entries = new ArrayList<>(m.entrySet());
    m.clear();
    entries.stream()
        .sorted(Comparator.comparing(Map.Entry::getValue, c))
        .forEachOrdered(e -> m.put(e.getKey(), e.getValue()));
}