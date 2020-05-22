Map.Entry<Map<Integer, BigDecimal>, List<BigDecimal>> result = data.entrySet().stream()
    .collect(Collectors.teeing(
             Collectors.toMap(
                     Map.Entry::getKey, 
                     i -> func1.apply(i.getValue())),
             Collectors.mapping(
                     i -> func1.andThen(func2).apply(i.getValue()),
                     Collectors.toList()),
             Map::entry));