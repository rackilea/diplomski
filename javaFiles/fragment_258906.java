List<Map<String, Long>> mapList = new ArrayList();
Map<String, Long>       map1    = new HashMap<>();
Map<String, Long>       map2    = new HashMap<>();
Map<String, Long>       map3    = new HashMap<>();
map1.put("col1", 90L);
map1.put("col2", 50L);
map1.put("col3", 10L);
map2.put("col1", 90L);
map2.put("col2", 50L);
map2.put("col3", 10L);
map3.put("col1", 90L);
map3.put("col2", 50L);
map3.put("col3", 10L);
mapList.add(map1);
mapList.add(map2);
mapList.add(map3);

Map<String, Long> sum = new HashMap<>();
mapList.forEach(map -> map.keySet().forEach(
                s -> {
                    mapList.stream()
                           .collect(Collectors.groupingBy(foo -> s,
                                Collectors.summingLong(foo -> map.get(s)))).forEach(
                                    (id, sumTargetCost) ->
                                            sum.put(s, sumTargetCost)
                    );
                }

));

Long sumVal1 = sum.get("col1"); // 270
Long sumVal2 = sum.get("col2"); // 150
Long sumVal3 = sum.get("col3"); // 30

System.out.println("SumVal1: " + sumVal1 + ", SumVal2: " + sumVal2 + ", SumVal3: " + sumVal3);