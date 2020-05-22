class MyMapOfList<K, V> {
    Map<K, List<V>> innerMap;

    public MyMapOfListOfList() {
        innerMap = new HashMap<K, V>();
    }

    public void put(K key, V value) {
        List<V> list = innerMap.get(key);
        if (list == null) {
            list = new ArrayList<V>();
            innerMap.put(key, list);
        }
        list.add(value);
    }
}