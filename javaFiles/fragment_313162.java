public static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
    SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
            new Comparator<Map.Entry<K, V>>() {
                @Override
                public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
            });
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
}