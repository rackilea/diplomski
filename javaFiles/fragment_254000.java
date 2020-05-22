public static List<Double> generateSequenceBigDecimal(BigDecimal start, BigDecimal end, BigDecimal step) {
  return Stream.iterate(start, d -> d.compareTo(end) <= 0, d -> d.add(step))
      .mapToDouble(BigDecimal::doubleValue)
      .boxed()
      .collect(toList());
}