private static final Map<String, String> map = ...

public static synchronized void put(String key, String value) {
    map.put(key, value);
}  

public static synchronized String get(String key) {
    return map.get(key);
}