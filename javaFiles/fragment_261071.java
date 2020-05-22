public Map<String, Double> analyse() {
    double sum = Stream.of(array).mapToDouble(d -> d.getValue()).sum();
    return Stream.of(array)
            .collect(Collectors.groupingBy(t -> t.getTime(),
                    Collectors.summingDouble(t -> t.getValue() * 100.0 / sum)));
}