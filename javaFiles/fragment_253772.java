public List<B> groupByNameAndSumWeight(List<B> list) {
    return list.stream()
            .collect(groupingBy(B::getName, reducing(BigDecimal.ZERO, B::getWeight, BigDecimal::add)))
            .entrySet().stream()
            .map(entry -> new B(entry.getKey(), entry.getValue()))
            .collect(toList());
}