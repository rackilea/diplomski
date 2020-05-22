static <K, V> void orderByValue(
        LinkedHashMap<K, V> m, final Comparator<? super V> c) {
    List<Map.Entry<K, V>> entries = new ArrayList<>(m.entrySet());

    Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
        @Override
        public int compare(Map.Entry<K, V> lhs, Map.Entry<K, V> rhs) {
            return c.compare(lhs.getValue(), rhs.getValue());
        }
    });

    m.clear();
    for(Map.Entry<K, V> e : entries) {
        m.put(e.getKey(), e.getValue());
    }
}