public Map<String, Object> convert (Map<String, Object> input, String key) {
    Map<String, Object> res = new HashMap<>();

    for (Entry<String, Object> e : input.entrySet()) {
        String newKey = key == "" ? e.getKey() : (key + "." + e.getKey());

        if (e.getValue() instanceof Map) {
            res.putAll(convert((Map) e.getValue(), newKey));  // recursive call
        } else {
            res.put(newKey, e.getValue());
        }
    }
    return res;
}