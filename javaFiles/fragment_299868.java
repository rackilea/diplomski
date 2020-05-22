void printHistogram(List<Integer> scores) {
    scores.stream().collect(Collectors.groupingBy(n -> n < 60 ? 5 : n / 10));
        .entrySet().stream().sorted(Map.Entry::comparingByKey)
        .map(entry -> entry.getValue().size());
        .map(size -> Stream.iterate(() -> "*").limit(size).collect(Collectors.joining()))
        .forEach(System.out::println);
}