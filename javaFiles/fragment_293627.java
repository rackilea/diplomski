private void init() {
    List<Map<Integer, String>> mapList = new ArrayList<>();

    Map<Integer, String> map1 = new HashMap<>();
    map1.put(1, "String1");
    mapList.add(map1);

    Map<Integer, String> map2 = new HashMap<>();
    map2.put(2, "String2");
    mapList.add(map2);

    Map<Integer, String> map3 = new HashMap<>();
    map3.put(1, "String3");
    mapList.add(map3);

    Map<Integer, String> map4 = new HashMap<>();
    map4.put(2, "String4");
    mapList.add(map4);

    Map<Integer, List<String>> response = mapList.stream()
            .flatMap(map -> map.entrySet().stream())
            .collect(
                    Collectors.groupingBy(
                            Map.Entry::getKey, 
                            Collectors.mapping(
                                    Map.Entry::getValue, 
                                    Collectors.toList()
                            )
                    )
            );
    response.forEach((i, l) -> {
        System.out.println("Integer: " + i + " / List: " + l);
    });
}