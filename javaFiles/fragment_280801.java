public static <N extends Number> double calculateMean(List<N> numbers) {
    double sum = 0.0;
    for (N number : numbers)
      sum += number.doubleValue();
    return sum / numbers.size();
  }