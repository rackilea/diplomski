public class ParallelTest {
    private static <T> T measure(Supplier<T> func) {
        long start = System.nanoTime();
        T result = func.get();
        long elapsed = System.nanoTime() - start;
        System.out.printf("Execution time %dns\n", elapsed);
        return result;
    }
    private static void measure(Runnable runnable) {
        measure(() -> { runnable.run(); return ""; });
    }
    private static int sum = 0; // Warning: data race
    private static void heavyComputation() {
        Permutations.of("abcdefghij").forEach(i -> ++sum);
    }
    public static void main(String... args) {
        measure(ParallelTest::heavyComputation);
        System.out.printf("Sum: %s\n", sum);
        measure(() -> IntStream.range(0, 10).forEach(i -> heavyComputation()));
        measure(() -> IntStream.range(0, 10).parallel().forEach(i -> heavyComputation()));
        System.out.printf("Sum: %s\n", sum);
    }
}