// Process map
if (map.containsKey("key3")) {
    Map<String, Object> nestedMap = (Map<String, Object>)map.get("key3");
    if (nestedMap.containsKey("key4")) {
        nestedMap.put("key4","000000");
    }
}