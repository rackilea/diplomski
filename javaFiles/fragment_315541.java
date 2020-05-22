import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (;;) {
            while (atomicInteger.get() < 5) {
                atomicInteger.getAndIncrement();
                Thread t = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        atomicInteger.getAndDecrement();
                    };
                };
                t.start();
            }
            Thread.sleep(100);
        }
    }
}