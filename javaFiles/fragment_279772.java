Set<String> filtered = Stream.of(map1, map2)
        .map(Map::entrySet)
        .flatMap(Set::stream)
        .filter(Map.Entry::getValue)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());