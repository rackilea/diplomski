public static Map<String, Long> getSortedMap(List<String> wordsList) {
    return wordsList.stream()
            .collect(
                    Collectors.groupingBy(Function.identity(),
                                          TreeMap::new,
                                          Collectors.counting())
            );
}