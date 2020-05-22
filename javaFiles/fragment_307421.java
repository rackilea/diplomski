@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class TestNewObject {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(TestNewObject.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Benchmark
    public Something newOperator() {
        return new Something();
    }

    @Benchmark
    public Something newInstance() throws InstantiationException, IllegalAccessException {
        return Something.class.newInstance();
    }

    static class Something {

    }
}