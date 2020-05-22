Map<String, Double> map1 = new HashMap<>();
map1.put("661", 123d);
map1.put("662", 321d);
map1.put("55", 3453.34);
map1.put("55001", 5322.44);
map1.put("55003", 10112.44);
map1.put("55004", 15555.74);

Map<String, Double> map = map1.entrySet()
        .stream()
        .collect(
            Collectors.groupingBy(
                entry -> entry.getKey().substring(0, 2), 
                Collectors.summingDouble(Map.Entry::getValue)
            )
        );

System.out.println(map);