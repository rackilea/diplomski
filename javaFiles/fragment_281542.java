static List<Integer> maxOccurrence(Map<Integer, List<Integer>> input) {
    return input.values().stream()
        .flatMap(list -> list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream())
        .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.maxBy(Comparator.naturalOrder()))))
        .entrySet().stream().sorted(Map.Entry.comparingByKey())
        .flatMap(e -> LongStream.range(0, e.getValue().get()).mapToObj(x -> e.getKey()))
        .collect(Collectors.toList());
}