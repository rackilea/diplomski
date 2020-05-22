Map<String, Map<String, Integer>> mapOfMaps = ...
TreeMap<String, List<Integer>> series = mapOfMaps.values().stream()
        .map(Map::entrySet)
        .flatMap(Set::stream)
        .collect(Collectors.groupingBy(Entry::getKey, TreeMap::new,
                Collectors.mapping(Entry::getValue, Collectors.toList())));