Map<Integer, Map<String, Object>> map;

for (Map.Entry<Integer, Map<String, Object>> entry : map.entrySet()) {
    Integer key = entry.getKey();
    Map<String, Object> value = entry.getValue();
    ...
}