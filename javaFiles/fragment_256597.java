@State(Scope.Benchmark)
public class Sqrt {
    double d = Math.random();
    float f = (float) d;

    @Benchmark
    public double sqrtD() {
        return Math.sqrt(d);
    }

    @Benchmark
    public float sqrtF() {
        return (float) Math.sqrt(f);
    }
}