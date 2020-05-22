List<Entry<String, Map<String, Long>>> result2 = queryResult.entrySet()
        .stream()
        .sorted(Entry.<String, Map<String, Long>>comparingByKey()
                .thenComparingLong(e -> e.getValue()
                        .values()
                        .stream()
                        .mapToLong(i -> i)
                        .sum()))
        .collect(Collectors.toList());