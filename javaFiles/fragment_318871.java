private <T extends MyObject> void addToMap(
        Collection<T> collection,
        Map<String, ? super T> map
) {
    for (T myObject : collection) {
        map.put(myObject.getName(), myObject);
    }
}