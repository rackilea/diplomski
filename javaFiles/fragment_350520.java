Map<String, List<String> map = new HashMap<>();
map.put("key", "key1, key2);
map.put("name", "name1, name2, name3");
map.put("code", "code1, code2");
//Start with 1st parameter, and pass 
//an empty LinkedHashMap and all entries will be added to this map.
traverseParam(map, 0, new LinkedHashMap<String, String>());