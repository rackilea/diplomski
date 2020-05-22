Map<Long, List<Integer>> merged = tests.stream()
    .map(test -> test.map)
    .map(Map::entrySet)
    .flatMap(Collection::stream)
    .collect(
            Collectors.groupingBy(
                    Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())
            )
    );