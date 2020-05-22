Map<String, Integer> map = new HashMap<>();
map.put("a",1);
map.put("b",2);

Map<Integer, String> mapInversed = 
    map.entrySet()
       .stream()
       .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))