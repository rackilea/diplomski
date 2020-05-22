for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    // Since integer division is used, we'll lose the "ones" digit
    Integer newKey = Integer.parseInt(entry.getKey()) / 10 * 10;

    List<String> value = newMap.get(newKey) {
    if (value == null) {
        value = new LinkedList<>();
        newMap.put(newKey, value);
    }
    value.addAll(entry.getValue());
}