import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StopWatchExample {

    public static void main(String[] args) throws InterruptedException {
        new StopWatchExample();
    }

    public StopWatchExample() throws InterruptedException {
        StopWatchRunnable stopWatch = new StopWatchRunnable();
        Thread thread = new Thread(stopWatch);
        thread.start();

        Thread.sleep(5000);
        System.out.println("Pause...");
        stopWatch.pause();
        Thread.sleep(5000);
        System.out.println("Resume...");
        stopWatch.resume();
        Thread.sleep(5000);
        System.out.println("Stop...");
        stopWatch.stop();
        thread.join();
        System.out.println("All done...");
    }

    public class StopWatch {

        private Instant startTime;
        private Duration totalRunTime = Duration.ZERO;

        public StopWatch start() {
            startTime = Instant.now();
            return this;
        }

        public StopWatch stop() {
            Duration runTime = Duration.between(startTime, Instant.now());
            totalRunTime = totalRunTime.plus(runTime);
            startTime = null;
            return this;
        }

        public StopWatch pause() {
            return stop();
        }

        public StopWatch resume() {
            return start();
        }

        public StopWatch reset() {
            stop();
            totalRunTime = Duration.ZERO;
            return this;
        }

        public boolean isRunning() {
            return startTime != null;
        }

        public Duration getDuration() {
            Duration currentDuration = Duration.ZERO;
            currentDuration = currentDuration.plus(totalRunTime);
            if (isRunning()) {
                Duration runTime = Duration.between(startTime, Instant.now());
                currentDuration = currentDuration.plus(runTime);
            }
            return currentDuration;
        }
    }

    public class StopWatchRunnable implements Runnable {

        private final Lock pauseLock = new ReentrantLock();
        private final Condition pauseCondtion = pauseLock.newCondition();
        private final AtomicBoolean isPaused = new AtomicBoolean(false);
        private final AtomicBoolean isRunning = new AtomicBoolean(true);

        private final StopWatch stopWatch = new StopWatch();

        @Override
        public void run() {
            stopWatch.start();
            while (isRunning.get()) {
                while (isPaused.get()) {
                    pauseLock.lock();
                    stopWatch.pause();
                    try {
                        pauseCondtion.await();
                    } catch (InterruptedException ex) {
                    } finally {
                        pauseLock.unlock();
                        stopWatch.resume();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                Duration duration = stopWatch.getDuration();
                String formatted = String.format("%dhrs %02dmins, %02dseconds", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
                System.out.println(formatted);
            }
        }

        public void stop() {
            pauseLock.lock();
            try {
                isPaused.set(false);
                isRunning.set(false);
            } finally {
                pauseCondtion.signalAll();
                pauseLock.unlock();
            }
        }

        public void pause() {
            pauseLock.lock();
            try {
                isPaused.set(true);
            } finally {
                pauseLock.unlock();
            }
        }

        public void resume() {
            pauseLock.lock();
            try {
                isPaused.set(false);
            } finally {
                pauseCondtion.signalAll();
                pauseLock.unlock();
            }
        }

    }

}