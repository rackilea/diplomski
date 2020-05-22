import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger counter = new AtomicInteger();
        // Change to StringBuffer to see "working" output
        final StringBuilder sb = new StringBuilder();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    sb.append(counter.incrementAndGet() + " ");
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sb);
    }
}