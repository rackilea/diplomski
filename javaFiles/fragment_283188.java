import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        new Test();
    }

    public Test() throws InterruptedException {
        Random rnd = new Random();
        for (int index = 0; index < 10; index++) {
            Thread t = new Thread(new Timeout(5, "Cookie " + index));
            t.start();
        }

        Thread.sleep(500);
    }

    public class Timeout implements Runnable {

        private Duration duration;
        private Instant startTime;
        private String label;

        public Timeout(int count, String label) {
            duration = Duration.ofSeconds(count);
            this.label = label;
        }

        @Override
        public void run() {
            long time = Long.MAX_VALUE;
            try {
                startTime = Instant.now();
                while (true) {
                    Duration runTime = Duration.between(startTime, Instant.now());
                    Duration remainingTime = duration.minus(runTime);
                    // You could also use remainingTime.getSeconds() == 0, but it
                    // depends on your desired level of accuracy
                    if (remainingTime.isNegative()) {
                        System.out.println("Out of time");
                        return;
                    } else {
                        if (time != remainingTime.getSeconds()) {
                            time = remainingTime.getSeconds();
                            System.out.println(label + " " + duration.getSeconds() + "/" + time);
                        }
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}