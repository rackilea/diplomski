@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode({ Mode.Throughput })
@Warmup(iterations = 10)
@Fork(value = 1)
@State(Scope.Benchmark)
public class MyBenchmark {
    private static final double CONSTANT = 1.6712 * 1000 * 60;
    private double x = 0;

    @Benchmark
    public void testCaseOne() {
        for (double i = 1; i < 1000_000; i++) {
            x += i * 1.6712 * 1000 * 60;
        }
    }

    @Benchmark
    public void testCaseTwo() {
        for (double i = 1; i < 1000_000; i++) {
            x += i * (1.6712 * 1000 * 60);
        }
    }

    @Benchmark
    public void testCaseThree() {
        for (double i = 1; i < 1000_000; i++) {
            x += i * 100272;
        }
    }

    @Benchmark
    public void testCaseFour() {
        final double constant = 1.6712 * 1000 * 60;
        for (double i = 1; i < 1000_000; i++) {
            x += i * constant;
        }
    }

    @Benchmark
    public void testCaseFive() {
        for (double i = 1; i < 1000_000; i++) {
            x += i * CONSTANT;
        }
    }
}