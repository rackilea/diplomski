@State(Scope.Benchmark)
public class Div {

    @Benchmark
    public void divConst(Blackhole blackhole) {
        long startNum = 0;
        long stopNum = 100000000L;

        for (long i = startNum; i <= stopNum; i++) {
            if (i % 50000 == 0) {
                blackhole.consume(i);
            }
        }
    }

    @Benchmark
    public void divVar(Blackhole blackhole) {
        long startNum = 0;
        long stopNum = 100000000L;
        long progressCheck = 50000;

        for (long i = startNum; i <= stopNum; i++) {
            if (i % progressCheck == 0) {
                blackhole.consume(i);
            }
        }
    }
}