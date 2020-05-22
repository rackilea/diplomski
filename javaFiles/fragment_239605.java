@State(Scope.Benchmark)
public class MathPowVsRawMultiplyTest {
    private double v;

    @Setup
    public void setup {
        v = new Random(System.currentTimeMillis()).nextDouble();
    }

    @Benchmark
    public double mathPow() {
        return Math.pow(v, 2.0);
    }

    @Benchmark
    public void rawMultiply() {
        return v * v;
    }
}