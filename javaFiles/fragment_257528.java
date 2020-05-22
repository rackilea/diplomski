Map<String, List<String>> map = servicesNames
        .stream()
        .map(ServiceName::getNames)
        .map(Map::entrySet)
        .flatMap(Set::stream)
        .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));