import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        new Test();
    }

    public Test() throws InterruptedException {
        List<Timeout> timers = new ArrayList<>(10);
        for (int index = 0; index < 10; index++) {
            timers.add(new Timeout(5, "Cookie " + index));
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Iterator<Timeout> it = timers.iterator();
                    while (it.hasNext()) {
                        Timeout timer = it.next();
                        timer.tick();
                        if (timer.isTimedOut()) {
                            it.remove();
                        }
                    }
                    Thread.yield();
                    if (timers.isEmpty()) {
                        return;
                    }
                }
            }
        });
        t.start();
        Thread.sleep(500);
    }

    public class Timeout {

        private Duration duration;
        private Instant startTime;
        private String label;

        private Long lastTime;
        private boolean timedOut;

        public Timeout(int count, String label) {
            duration = Duration.ofSeconds(count);
            this.label = label;
        }

        public boolean isTimedOut() {
            return timedOut;
        }

        public void tick() {
            if (timedOut) {
                return;
            }
            if (startTime == null) {
                startTime = Instant.now();
            }
            Duration runTime = Duration.between(startTime, Instant.now());
            Duration remainingTime = duration.minus(runTime);
            // You could also use remainingTime.getSeconds() == 0, but it
            // depends on your desired level of accuracy
            if (remainingTime.isNegative()) {
                System.out.println("Out of time");
                timedOut = true;
            } else {
                if (lastTime == null || lastTime != remainingTime.getSeconds()) {
                    lastTime = remainingTime.getSeconds();
                    System.out.println(label + " " + duration.getSeconds() + "/" + lastTime);
                }
            }
        }
    }
}