public void changeValue(Integer key, Integer value) {
    if (!map.containsKey(key)) {
        throw new IllegalArgumentException("Invalid key: " + key);
    }
    map.put(key, value);
}