public static Map<String, Object> covert(Map<String, String> map) {
    Map<String, Object> result = new HashMap<>();
    map.forEach((key, value) -> parseAndPut(result, key, value));
    return result;
}

@SuppressWarnings("unchecked")
private static void parseAndPut(Map<String, Object> map, String key, String value) {
    String[] keys = key.split("\\.");
    if (keys.length == 1) {
        map.put(key, value);
    } else if (keys.length > 1) {
        String subKey = keys[0];
        Map<String, Object> valueMap = (Map<String, Object>) map.computeIfAbsent(subKey, s -> new HashMap<>());
        int beginIndex = key.indexOf(subKey) + subKey.length() + 1;
        parseAndPut(valueMap, key.substring(beginIndex), value);
    }
}