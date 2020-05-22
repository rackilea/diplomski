import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
    private static final int RUN_TIMES = 100000000;
    private static final int HEATUP_TIMES = 100000;
    private static final int RESET_EVERY = 1000;

    public static void main(String[] args) {
        Test instance = new Test();
        instance.doTest();
    }

    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private AtomicLong n;

    private void doTest() {
        Runnable t1 = new Runnable() {
            public void run() {
                if (
                        (a > b || a > c)
                        && (a > d || b > d) 
                        && (c > e || e > f)
                        && (f > a || f > b) 
                        && (f > e || f > a)
                        && (a > f || f > d) 
                        && (d > e || e > d)
                        && (f > e || f > a) 
                        && (f > b || f > a)) {
                    n.incrementAndGet();
                }
            }

            public String toString() {
                return "task1";
            }
        };
        Runnable t2 = new Runnable() {
            public void run() {
                if (a > b || a > c)
                    if (a > d || b > d)
                        if (c > e || e > f)
                            if (f > a || f > b)
                                if ((f > e || f > a))
                                    if ((a > f || f > d))
                                        if ((d > e || e > d))
                                            if ((f > e || f > a))
                                                n.incrementAndGet();
            }
            public String toString() {
                return "task2";
            }
        };

        List<Runnable> tasks = Arrays.asList(t1, t2, t1, t2, t1, t2, t1, t2, t1, t2);
        for (Runnable r: tasks) {
            benchmark(r);
        }
    }

    private void reset() {
        java.util.Random rnd = new java.util.Random();
        this.a = rnd.nextLong();
        this.b = rnd.nextLong();
        this.c = rnd.nextLong();
        this.d = rnd.nextLong();
        this.e = rnd.nextLong();
        this.f = rnd.nextLong();
    }

    private void benchmark(Runnable t) {
        n = new AtomicLong();
        reset();
        for (int i = 0; i < HEATUP_TIMES; i++) {
            t.run();
        }
        long t0 = System.nanoTime();
        int r = 0;
        for (int i = 0; i < RUN_TIMES; i++) {
            if (r == 0) {
                reset();
                r = RESET_EVERY + 1;
            }
            r--;
            t.run();
        }
        long t1 = System.nanoTime();
        System.out.println(String.format("Task %s was run %d times in %.3f ms",
                t, RUN_TIMES, (t1 - t0) / 1000000d));
        System.out.println("n = " + n);
    }
}