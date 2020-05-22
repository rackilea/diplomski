@State(Scope.Thread)
@Warmup(iterations = 10, time = 200, timeUnit = MILLISECONDS)
@Measurement(iterations = 20, time = 500, timeUnit = MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

  static double[] array;

  static {
    int num_of_elements = 100;
    array = new double[num_of_elements];
    for (int i = 0; i < num_of_elements; i++) {
      array[i] = i + 1;
    }
  }

  double result = 0;

  @Benchmark
  public void baseline(Blackhole blackhole) {
    result = 1;
    result = result / 1.0;
    blackhole.consume(result);
  }

  @Benchmark
  public void testInversionSumForLoop(Blackhole blackhole) {
    for (int i = 0; i < array.length; i++) {
      result += 1.0 / array[i];
    }
    blackhole.consume(result);
  }

  @Benchmark
  public void testInversionSumUsingStreams(Blackhole blackhole) {
    result = Arrays.stream(array).map(d -> 1 / d).sum();
    blackhole.consume(result);
  }

}