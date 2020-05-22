private static final Map<Integer, Map<String, String>> directory = new HashMap<>();

public static void put(Integer key1, String key2, String value) {
    Map<String, String> map = directory.get(key1);
    if (map == null)
        directory.put(key1, map = new HashMap<>());
    map.put(key2, value);
}