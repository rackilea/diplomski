private static <K, V extends Comparable<V>> Map<K, V> sortByComparator(Map<K, V> unsortMap) {

    List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

    //sort list based on comparator
    Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        @Override
         public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
           return o1.getValue().compareTo(o2.getValue());
         }
    });

    //put sorted list into map again
    Map<K, V> sortedMap = new LinkedHashMap<K, V>();
    for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext();) {
         Map.Entry<K, V> entry = it.next();
         sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
}