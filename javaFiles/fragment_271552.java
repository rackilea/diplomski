@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class SO26775395 {

  @Param({"10", "1000", "1000000"}) int n;
  List<Weighter> weights;

  @Setup public void setup() {
    weights = new Random().doubles(n)
            .mapToObj(Weighter::new)
            .collect(toList());
  }

  @Benchmark public DoubleSummaryStatistics collector() {
    return weights.stream().collect(Collectors.summarizingDouble(Weighter::w));
  }

  @Benchmark public DoubleSummaryStatistics summary() {
    return weights.stream().mapToDouble(Weighter::w).summaryStatistics();
  }

  public static class Weighter {
    private final double w;
    public Weighter(double w) { this.w = w; }
    public double w() { return w; }
  }

}