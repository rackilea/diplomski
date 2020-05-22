Map<Integer, Map<LocalDate, CustomObject>> input = ...

Map<LocalDate,List<CustomObject>> grouped =
    input.values() // Collection<Map<LocalDate, CustomObject>>
         .stream() // Stream<Map<LocalDate, CustomObject>>
         .flatMap(m -> m.entrySet().stream()) // Stream<Map.Entry<LocalDate, CustomObject>>
         .collect(Collectors.groupingBy(Map.Entry::getKey,
                                        Collectors.mapping(Map.Entry::getValue,
                                                           Collectors.toList())));