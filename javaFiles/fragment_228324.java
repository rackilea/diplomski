Map<String,List<Integer>> map = Arrays.stream(OperatorType.values()).collect(Collectors.toMap(OperatorType::getKey, OperatorType::getSupportedtypes));
map.forEach((k,v) -> System.out.println(k + " " + v));
System.out.println("");

Map<Integer,List<OperatorType>> map2 = 
        map.entrySet().stream()
        .flatMap(e -> e.getValue().stream().map(f -> new AbstractMap.SimpleEntry<>(f,e.getKey())))
        .collect(Collectors.groupingBy(r -> r.getKey(), Collectors.mapping(s -> Enum.valueOf(OperatorType.class, s.getValue()), Collectors.toList())));
map2.forEach((k,v) -> System.out.println(k + " " + v));