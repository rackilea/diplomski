Map<Long, Double> merged = tests.stream()
        .map(test -> test.map)
        .map(Map::entrySet)
        .flatMap(Collection::stream)
        .collect(
                Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                )
        );