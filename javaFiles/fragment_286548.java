List<Entry<String, Map<String, Long>>> result = queryResult.entrySet()
        .stream()
        .sorted(Comparator.comparing(Entry<String, Map<String, Long>>::getKey)
                .thenComparingLong(e -> e.getValue()
                        .values()
                        .stream()
                        .mapToLong(i -> i)
                        .sum()))
        .collect(Collectors.toList());