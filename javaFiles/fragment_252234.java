Map<Integer, Integer> map = new HashMap<>();
map.put(1, 10);
map.put(12, 3);
map.put(2, 45);
map.put(6, 34);
System.out.println(map);

LinkedHashMap<Integer, Integer> map2 = 
    map.entrySet()
       .stream()             
       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
       .collect(Collectors.toMap(e -> e.getKey(), 
                                 e -> e.getValue(), 
                                 (e1, e2) -> null, // or throw an exception
                                 () -> new LinkedHashMap<Integer, Integer>()));

System.out.println(map2);