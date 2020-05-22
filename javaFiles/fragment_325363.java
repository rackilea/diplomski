Map<String, Long> wordCount = frequency.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
        .thenComparing(Map.Entry.comparingByKey()))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
        (e1, e2) -> e2, LinkedHashMap::new));