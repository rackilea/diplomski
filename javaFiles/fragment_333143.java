Map<String, Map<String, List<String>>> testMap = 
    foos.stream()
        .collect(Collectors.groupingBy(Foo::getAreaName,
                                       Collectors.groupingBy(Foo::getObjectName,
                                                             Collectors.mapping(Foo::getLineName,
                                                                                Collectors.toList()))));