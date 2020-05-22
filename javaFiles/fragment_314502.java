Map<String, Integer> instance = new TreeMap<String, Integer>();

@SuppressWarnings("unchecked")
Map<String, Integer> map =
    createMap((Class<? extends Map<String, Integer>>)instance.getClass());

map.put("x", 1);

System.out.println("THIS IS x: " + map.get("x"));