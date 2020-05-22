public Map<String, Integer> analyse() {
    long sum = Stream.of(array).mapToLong(d -> d.getValue()).sum();
    Map<String, Long> map = Stream.of(array)
            .collect(Collectors.groupingBy(t -> t.getTime(),
                    Collectors.summingLong(t -> t.getValue())));
    return map.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey,
                    e -> (int) Math.round(100.0 * e.getValue() / sum)));
}