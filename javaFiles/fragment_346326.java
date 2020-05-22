Map<Pair<DateTime, String>, Integer> collect = entities.stream()
    .collect(Collectors.groupingBy(e -> Pair.of(e.getTimestamp(), e.getName())))
    .entrySet().stream()
    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().collect(
        Collector.of(EntityAccumulator::new,
                     EntityAccumulator::calculate,
                     EntityAccumulator::add,
                     ea -> ea.result,
                     Collector.Characteristics.UNORDERED))));