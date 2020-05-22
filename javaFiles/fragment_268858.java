@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class CSVParsing {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(CSVParsing.class.getSimpleName())
                .jvmArgs("-ea")
                .shouldFailOnError(true)
                .build();
        new Runner(opt).run();
    }

    @Param(value = { "a,e, b,c,d",
            "a,b,c,d, a,b,c,da,b,c,da,b,c,da,b,c,da,b,c,da,b,c,da,b,c,da,b,c,d, e",
            "r, m, n, t,r, m, n, tr, m, n, tr, m, n, tr, m, n, tr, m, n, tr, m, n, tr, m, n, t, e" })
    String csv;

    @Fork(1)
    @Benchmark
    public boolean containsSimple() {
        return Arrays.asList(csv.split(",")).contains("e");
    }

    @Fork(1)
    @Benchmark
    public boolean containsStream() {
        return Arrays.asList(csv.split(",")).stream().filter(e -> e.equals("e")).findFirst().isPresent();
    }

    @Fork(1)
    @Benchmark
    public boolean containsStreamParallel() {
        return Arrays.asList(csv.split(",")).stream().filter(e -> e.equals("e")).findFirst().isPresent();
    }
}