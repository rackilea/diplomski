Map<String, String> map = Map.of("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
JSONArray arr = map.entrySet().stream()
    .map(e -> Map.of("key", e.getKey(), "value", e.getValue()))
    .map(JSONObject::new)
    .collect(JSONArray::new, JSONArray::add, JSONArray::addAll);
System.out.println(arr);