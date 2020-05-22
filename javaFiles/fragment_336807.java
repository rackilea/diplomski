package com.sam.tests;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

public class SortBenchmark {

    public static class OrbitSort {
        // Sorting algorithm
        public static void sort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                int L = i - 1;
                int R = i + 1;

                // Odd case (with a central item)
                while (L >= 0 && R < array.length) {
                    if (array[L] > array[R])
                        swap(array, L, R);

                    L--;
                    R++;
                }

                // Even case (with no central item)
                L = i;
                R = i + 1;
                while (L >= 0 && R < array.length) {
                    if (array[L] > array[R])
                        swap(array, L, R);

                    L--;
                    R++;
                }
            }
        }

        // Swap two items in array.
        public static void swap(int[] array, int x, int y) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }

    public static class BubbleSort {

        public static void sort(int[] numbers) {
            boolean swapped = true;
            for (int i = numbers.length - 1; i > 0 && swapped; i--) {
                swapped = false;
                for (int j = 0; j < i; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }

    public static class TestDataFactory {

        public static enum ElementOrder {
            Ascending, Descending, Random
        }

        public static int[] createIntArray(final int size, final ElementOrder elementOrder) {
            int[] array = new int[size];

            switch (elementOrder) {
            case Ascending:
                for (int i = 0; i < size; ++i)
                    array[i] = i;
                break;
            case Descending:
                for (int i = 0; i < size; ++i)
                    array[i] = size - i - 1;
                break;
            case Random:
            default:
                Random rg = new Random(System.nanoTime());
                for (int i = 0; i < size; ++i)
                    array[i] = rg.nextInt(size);
                break;
            }

            return array;
        }
    }

    public static class Benchmark {
        // misc constants
        public static final int  NANOS_PER_MSEC                    = 1000000;

        // config constants
        public static final int  BIGDECIMAL_PRECISION              = 6;

        // constant defaults
        public static final long AUTOTUNING_MIN_ITERATIONS_DEFAULT = 1;
        public static final long AUTOTUNING_MIN_DURATION_DEFAULT   = 125;

        public static final long BENCHMARK_MIN_ITERATIONS_DEFAULT  = 1;
        public static final long BENCHMARK_MAX_ITERATIONS_DEFAULT  = Integer.MAX_VALUE;
        public static final long BENCHMARK_TARGET_DURATION_DEFAULT = 125;

        // private static final ThreadMXBean threadBean =
        // ManagementFactory.getThreadMXBean();

        public static final long getNanoTime() {
            // return threadBean.getCurrentThreadCpuTime();// not good, runs at
            // some time slice resolution
            return System.nanoTime();
        }

        public static class Result {
            public String name;
            public long   iterations;
            public long   totalTime; // nanoseconds

            public Result(String name, long iterations, long startTime, long endTime) {
                this.name = name;
                this.iterations = iterations;
                this.totalTime = endTime - startTime;
            }

            @Override
            public String toString() {
                final double totalTimeMSecs = ((double) totalTime) / NANOS_PER_MSEC;

                final BigDecimal avgTimeMsecs = new BigDecimal(this.totalTime).divide(new BigDecimal(this.iterations).multiply(new BigDecimal(NANOS_PER_MSEC)),
                        BIGDECIMAL_PRECISION, RoundingMode.HALF_UP);

                final String newLine = System.getProperty("line.separator");
                StringBuilder sb = new StringBuilder();
                sb.append(name).append(newLine);
                sb.append("    ").append("iterations : ").append(iterations).append(newLine);
                sb.append("    ").append("total time : ").append(totalTimeMSecs).append(" ms").append(newLine);
                sb.append("    ").append("avg time   : ").append(avgTimeMsecs).append(" ms").append(newLine);
                return sb.toString();
            }
        }

        public static <T> Result executionTime(final String name, final long iterations, final long warmupIterations, final Callable<T> test) throws Exception {
            // vars
            @SuppressWarnings("unused")
            T ret;
            long startTime;
            long endTime;

            // warmup
            for (long i = 0; i < warmupIterations; ++i)
                ret = test.call();

            // actual benchmark iterations
            {
                startTime = getNanoTime();
                for (long i = 0; i < iterations; ++i)
                    ret = test.call();
                endTime = getNanoTime();
            }

            // return result
            return new Result(name, iterations, startTime, endTime);
        }

        /**
         * Auto tuned execution time measurement for test callbacks with steady
         * execution time
         * 
         * @param name
         * @param test
         * @return
         * @throws Exception
         */
        public static <T> Result executionTimeAutotuned(final String name, final Callable<T> test) throws Exception {
            final long autoTuningMinIterations = AUTOTUNING_MIN_ITERATIONS_DEFAULT;
            final long autoTuningMinDuration = AUTOTUNING_MIN_DURATION_DEFAULT;

            final long benchmarkTargetDuration = BENCHMARK_TARGET_DURATION_DEFAULT;
            final long benchmarkMinIterations = BENCHMARK_MIN_ITERATIONS_DEFAULT;
            final long benchmarkMaxIterations = BENCHMARK_MAX_ITERATIONS_DEFAULT;

            // vars
            @SuppressWarnings("unused")
            T ret;
            final int prevThreadPriority;
            long warmupIterations = 0;
            long autoTuningDuration = 0;
            long iterations = benchmarkMinIterations;
            long startTime;
            long endTime;

            // store current thread priority and set it to max
            prevThreadPriority = Thread.currentThread().getPriority();
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

            // warmup and iteration count tuning
            {
                final long autoTuningMinTimeNanos = autoTuningMinDuration * NANOS_PER_MSEC;
                long autoTuningConsecutiveLoops = 1;
                double avgExecutionTime = 0;

                do {
                    {
                        startTime = getNanoTime();
                        for (long i = 0; i < autoTuningConsecutiveLoops; ++i, ++warmupIterations) {
                            ret = test.call();
                        }
                        endTime = getNanoTime();
                        autoTuningDuration += (endTime - startTime);
                    }
                    avgExecutionTime = ((double) autoTuningDuration) / ((double) (warmupIterations));
                    if ((autoTuningDuration >= autoTuningMinTimeNanos) && (warmupIterations >= autoTuningMinIterations)) {
                        break;
                    } else {
                        final double remainingAutotuningIterations = ((double) (autoTuningMinTimeNanos - autoTuningDuration)) / avgExecutionTime;
                        autoTuningConsecutiveLoops = Math.max(1, Math.min(Integer.MAX_VALUE, (long) Math.ceil(remainingAutotuningIterations)));
                    }
                } while (warmupIterations < Integer.MAX_VALUE);

                final double requiredIterations = ((double) benchmarkTargetDuration * NANOS_PER_MSEC) / avgExecutionTime;
                iterations = Math.max(1, Math.min(benchmarkMaxIterations, (long) Math.ceil(requiredIterations)));
            }

            // actual benchmark iterations
            {
                startTime = getNanoTime();
                for (long i = 0; i < iterations; ++i)
                    ret = test.call();
                endTime = getNanoTime();
            }

            // restore previous thread priority
            Thread.currentThread().setPriority(prevThreadPriority);

            // return result
            return new Result(name, iterations, startTime, endTime);
        }
    }

    public static void executeBenchmark(int inputSize, ArrayList<Benchmark.Result> results) {
        // final int[] inputArray = { 15, 8, 6, 3, 11, 1, 2, 0, 14, 13, 7, 9, 4,
        // 10, 5, 12 };
        final int[] inputArray = TestDataFactory.createIntArray(inputSize, TestDataFactory.ElementOrder.Random);

        try {
            // compare against Arrays.sort()
            {
                final int[] ref = inputArray.clone();
                Arrays.sort(ref);
                {
                    int[] temp = inputArray.clone();
                    BubbleSort.sort(temp);
                    if (!Arrays.equals(temp, ref))
                        throw new Exception("BubbleSort.sort() failed");
                }
                {
                    int[] temp = inputArray.clone();
                    OrbitSort.sort(temp);
                    if (!Arrays.equals(temp, ref))
                        throw new Exception("OrbitSort.sort() failed");
                }
            }

            results.add(Benchmark.executionTimeAutotuned("Arrays.sort()", new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    int[] temp = Arrays.copyOf(inputArray, inputArray.length);
                    Arrays.sort(temp);
                    return null;
                }
            }));
            results.add(Benchmark.executionTimeAutotuned("BubbleSort.sort()", new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    int[] temp = Arrays.copyOf(inputArray, inputArray.length);
                    BubbleSort.sort(temp);
                    return null;
                }
            }));
            results.add(Benchmark.executionTimeAutotuned("OrbitSort.sort()", new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    int[] temp = Arrays.copyOf(inputArray, inputArray.length);
                    OrbitSort.sort(temp);
                    return null;
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Benchmark.Result> results = new ArrayList<Benchmark.Result>();

        for (int i = 16; i <= 16384; i <<= 1) {
            results.clear();
            executeBenchmark(i, results);
            System.out.println("input size : " + i);
            System.out.println("");
            for (Benchmark.Result result : results) {
                System.out.print(result.toString());
            }
            System.out.println("----------------------------------------------------");
        }

    }
}