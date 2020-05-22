@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(10)
@State(Scope.Thread)
public class Longs {

    public static final int COUNT = 10;

    private Long[] refLongs;
    private long[] primLongs;

    /*
     * Implementation notes:
     *   - copying the array from the field keeps the constant
     *     optimizations away, but we implicitly counting the
     *     costs of arraycopy() in;
     *   - two additional baseline experiments quantify the
     *     scale of arraycopy effects (note you can't directly
     *     subtract the baseline scores from the tests, because
     *     the code is mixed together;
     *   - the resulting arrays are always fed back into JMH
     *     to prevent dead-code elimination
     */

    @Setup
    public void setup() {
        primLongs = new long[COUNT];
        for (int i = 0; i < COUNT; i++) {
            primLongs[i] = 12l;
        }

        refLongs = new Long[COUNT];
        for (int i = 0; i < COUNT; i++) {
            refLongs[i] = 12l;
        }
    }

    @GenerateMicroBenchmark
    public long[] prim_baseline() {
        long[] d = new long[COUNT];
        System.arraycopy(primLongs, 0, d, 0, COUNT);
        return d;
    }

    @GenerateMicroBenchmark
    public long[] prim_sort() {
        long[] d = new long[COUNT];
        System.arraycopy(primLongs, 0, d, 0, COUNT);
        Arrays.sort(d);
        return d;
    }

    @GenerateMicroBenchmark
    public Long[] ref_baseline() {
        Long[] d = new Long[COUNT];
        System.arraycopy(refLongs, 0, d, 0, COUNT);
        return d;
    }

    @GenerateMicroBenchmark
    public Long[] ref_sort() {
        Long[] d = new Long[COUNT];
        System.arraycopy(refLongs, 0, d, 0, COUNT);
        Arrays.sort(d);
        return d;
    }

}