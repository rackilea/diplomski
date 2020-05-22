Map<String, Integer> map = new HashMap<String, Integer>();
map.put("One", 1);
map.put("Two", 2);

Something<String> something = new Something<String>("One");
Integer value = something.getValueForKey(map);