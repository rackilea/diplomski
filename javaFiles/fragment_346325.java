Map<Pair<DateTime, String>, Integer> collect = entities.stream()
    .collect(Collectors.groupingBy(
        entity -> Pair.of(entity.getTimestamp(), entity.getName()),
        Collector.of(EntityAccumulator::new,
                     EntityAccumulator::calculate,
                     EntityAccumulator::add,
                     ea -> ea.result,
                     Collector.Characteristics.UNORDERED)));