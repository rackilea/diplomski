@BenchmarkMode({ Mode.AverageTime, Mode.SingleShotTime })
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class UUIDRandom {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(UUIDRandom.class.getSimpleName()).build();
        new Runner(opt).run();
    }

    @Benchmark
    @Fork(1)
    public UUID random() {
        return UUID.randomUUID();
    }
}