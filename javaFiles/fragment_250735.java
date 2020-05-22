Map<String, Integer> map1 = new HashMap<>();
 Map<String, Integer> map2 = new HashMap<>();

 map1.put("a", 1);
 map2.put("a", 2);

 Map<String, Integer> map3 = new HashMap<>(map1);
 map2.forEach((key, value) -> map3.merge(key, value, (v1,v2) -> v1+v2));
 System.out.println(map3); // a=3