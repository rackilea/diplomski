public class IntLoopMain {
    public static long fib(int n) {
        long a = 0;
        long b = 1;
        for (long i = 0; i < n; ++i) {  // note: loop counter of type long
            long c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    static volatile long total = 0;

    public static void main(String... args) {
        System.out.println("Warming up the JIT... ");

        long start = 0;
        for (int i = -100000; i < 200_000_000; ++i) {
            if (i == 0) {
                start = System.nanoTime();
                System.out.println("Starting measurement");
            }
            total += fib(46 + (i & 3));
        }
        long time = System.nanoTime() - start;
        if (total == 0)
            System.out.println(total);

        System.out.printf("Took %.3f secs%n", time / 1e9);
    }
}