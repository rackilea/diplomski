package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class Test {

    @State(Scope.Benchmark)
    public static class Input {

        public static final Random rng = new Random();
        final int[] array;
        final int[] expected;

        public Input() {
            final Random r = new Random();
            this.array = new int[200_000];
            for (int i = 0; i < this.array.length; i++) {
                this.array[i] = i;
            }
            this.expected = Arrays.copyOf(this.array, this.array.length);

            // Fisher-Yates shuffle
            for (int i = this.array.length - 1; i > 0; --i) {
                int swap = Input.rng.nextInt(i);
                int tmp = this.array[swap];
                this.array[swap] = this.array[i];
                this.array[i] = tmp;
            }
        }
    }

    @Benchmark
    public void benchSort1(final Input in) {
        insertionSort1(in.array);
    }

    @Benchmark
    public void benchSort2(final Input in) {
        insertionSort2(in.array);
    }

    @Benchmark
    public void benchSort3(final Input in) {
        insertionSort3(in.array);
    }

    public static void insertionSort1(int[] intArray) {
        int n = intArray.length;
        for (int k = 1; k < n; k++) {
            int cur = intArray[k];
            int j = k;
            while (j > 0 && intArray[j - 1] > cur) {
                intArray[j] = intArray[j - 1];
                j--;
            }
            intArray[j] = cur;
        }
    }

    public static void insertionSort2(int[] input) {
        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }

    public static void insertionSort3(int[] input) {
        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] arg) throws Exception {
        Options option = new OptionsBuilder().include(Test.class.getSimpleName()).build();
        new Runner(option).run();
    }
}