@State(Scope.Benchmark)
public class Inline {
    double x = 111;
    double y = 222;

    @Benchmark
    public double inline() {
        return doInline(x, y);

    }

    @Benchmark
    public double noinline() {
        return dontInline(x, y);
    }

    @CompilerControl(CompilerControl.Mode.INLINE)
    private double doInline(double a, double b) {
        return new Vector2D(a, b).norm();
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private double dontInline(double a, double b) {
        return new Vector2D(a, b).norm();
    }

    static class Vector2D {
        private final double x;
        private final double y;

        public Vector2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double norm() {
            return Math.sqrt(x * x + y * y);
        }
    }
}