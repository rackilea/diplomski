ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

for (String key : map.keySet()) {
    System.out.println(key + " " + map.get(key));
}

for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey().toString();
    Integer value = entry.getValue();
    System.out.println("key, " + key + " value " + value);
}