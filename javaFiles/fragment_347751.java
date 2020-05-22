public void add(String key, String value) {
    if (!map.containsKey(key)) {
        map.put(key, new LinkedList<String>());
    }
    map.put(key, value);
}