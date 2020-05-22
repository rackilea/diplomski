@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Test {
    @Benchmark
    public byte[] test(String str) throws UnsupportedEncodingException {
        return str.getBytes("ISO-8859-1");
    }
}