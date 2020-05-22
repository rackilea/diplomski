private static void putStuffInMap (String key, int value) {
    Integer returnedValue = tileColorMap.put(key, value);
    if (returnedValue != null) {
        throw new RuntimeException("Duplicate Keys!");
    }
}