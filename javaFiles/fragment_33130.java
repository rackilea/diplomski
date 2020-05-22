if (map.containsKey(key) {
    Object storedValue = map.get(key);
    if (storedValue == null ? value == null : storedValue.equals(value)) {
        map.remove(key);
    }
}