@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
public class MainBenchmark {

    @Param({"10000"})
    private int n;

    private int[][] testData;

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(MainBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }


    @Setup
    public void setup() {
        testData = createData();
    }

    @Benchmark
    public void rowFirst(Blackhole bh) {
        for (int i = 0; i < testData.length; i++) {
            for (int j = 0; j < testData[0].length; j++) {
                int tmp = testData[i][j];
                bh.consume(tmp);
            }
        }
    }

    @Benchmark
    public void columnFirst(Blackhole bh) {
        for (int j = 0; j < testData[0].length; j++) {
            for (int i = 0; i < testData.length; i++) {
                int tmp = testData[i][j];
                bh.consume(tmp);
            }
        }
    }

    private int[][] createData() {
        int[][] ints = new int[n][n];
        for (int[] anInt : ints) {
            Arrays.fill(anInt, 0);
        }
        return ints;
    }
}