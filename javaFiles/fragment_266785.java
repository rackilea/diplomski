BiMap<String, Long> map = HashBiMap.create();
map.put("a", 1L);
map.put("b", 2L);
map.put("c", 3L);

System.out.println(map.get("b")); // 2L
System.out.println(map.inverse().get(2L)); // "b"