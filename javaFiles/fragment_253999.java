public static List<Double> generateSequenceIntStream(int start, int end, int step, double multiplier) {
  return IntStream.iterate(start, i -> i <= end, i -> i + step)
      .mapToDouble(i -> i * multiplier)
      .boxed()
      .collect(toList());
}