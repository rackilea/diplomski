public static void set(Map<String, Object> map, String path, Object value) {
    String[] parts = path.split("\\.");
    for(int i = 0; i < parts.length-1 ; i++) {
        String key = parts[i];
        Map<String, Object> map2 = (Map<String, Object>) map.get(key);
        if (map2 == null) {
            map.put(key, map2 = new LinkedHashMap<String, Object>());
        }
        map = map2;
    }
    map.put(parts[parts.length - 1], value);
}

set(example, "level1.level2.string", "test");
set(example, "level1.level2.int", 1);