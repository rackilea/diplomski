@Fork(1)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.AverageTime)
public class HashCodeBenchmark {
    private final Object object = new Object();

    @Benchmark
    @Threads(1)
    public void singleThread(Blackhole blackhole){
        blackhole.consume(object.hashCode());
    }

    @Benchmark
    @Threads(2)
    public void twoThreads(Blackhole blackhole){
        blackhole.consume(object.hashCode());
    }

    @Benchmark
    @Threads(4)
    public void fourThreads(Blackhole blackhole){
        blackhole.consume(object.hashCode());
    }

    @Benchmark
    @Threads(8)
    public void eightThreads(Blackhole blackhole){
        blackhole.consume(object.hashCode());
    }
}