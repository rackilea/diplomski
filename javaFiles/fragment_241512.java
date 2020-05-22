import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1000, timeUnit = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(3)
@State(Scope.Benchmark)
public class StreamTest {

    private static final int[] ARRAY = new Random().ints(100000000, -10, 10).toArray();

    @Benchmark
    public int[] shiftSolution() {
        int[] nums1 = new int[ARRAY.length];
        int k = -1;
        for (int i = 0; i < ARRAY.length; i++) {
            if (ARRAY[i] != 0) {
                k++;
                nums1[k] = ARRAY[i];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            ARRAY[i] = nums1[i];

        }
        return nums1;
    }

    @Benchmark
    public int[] alternative() {
        int[] result = new int[ARRAY.length];
        int k = 0;
        for (int v : ARRAY) {
            if (v != 0) {
                result[k++] = v;
            }
        }
        return result;
    }

}