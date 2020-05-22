Map<String,List<Foo>> collect = 
    fooList.stream()
           .flatMap(f -> f.getOrgan().stream().map(o -> new SimpleEntry<>(o,f)))
           .collect(Collectors.groupingBy(Map.Entry::getKey,
                                          Collectors.mapping(Map.Entry::getValue,
                                                             Collectors.toList())));