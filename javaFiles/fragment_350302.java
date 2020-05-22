Map.Entry<Map<Integer, BigDecimal>, List<BigDecimal>> result = data.entrySet().stream()
    .map(i -> Map.entry(i.getKey(), func1.apply(i.getValue())))
    .collect(Collectors.teeing(
             Collectors.toMap(
                     Map.Entry::getKey, 
                     Map.Entry::getValue),
             Collectors.mapping(
                     i -> func2.apply(i.getValue()),
                     Collectors.toList()),
             Map::entry));