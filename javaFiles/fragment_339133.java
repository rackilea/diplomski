public static <K, V extends Comparable<V>> Map<K, V> sortMap2(final Map<K, V> map) {
    Map<K, V> sortedMap = new TreeMap<K, V>(new Comparator<K>() {
        public int compare(K o1, K o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    });
    sortedMap.putAll(map);
    return sortedMap;
}