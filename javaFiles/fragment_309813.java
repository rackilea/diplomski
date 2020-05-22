import java.util.concurrent.atomic.AtomicInteger;

public class Number implements Runnable {
    public static AtomicInteger numup = new AtomicInteger(0);
    public static AtomicInteger numdown = new AtomicInteger(10);

    public Number() {
    }

    public static void main(String args[]) {
        Number number = new Number();
        Thread T1 = new Thread(number, "up");
        Thread T2 = new Thread(number, "down");
        T1.start();
        T2.start();

        while (true) {
            if (numup.get() == 5 && numdown.get() == 5) {
                System.out.println("Meet!");
                System.exit(0);
            }
        }
    }

    public void run() {
        while (true) {
            if (Thread.currentThread().getName().equals("up")) {

                numup.incrementAndGet();
                System.out.println(numup);

            } else if (Thread.currentThread().getName().equals("down")) {

                numdown.decrementAndGet();
                System.out.println(numdown);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("wake!");
            }
        }

    }
}