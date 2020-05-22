Map<String, Integer> map = new HashMap<>();

    map.put("a", 4);
    map.put("b", 9);
    map.put("c", 1);

    Map<String, Integer> orderedByValueMap =
            map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (o1, o2) -> o1, LinkedHashMap::new));

    System.out.println(orderedByValueMap);