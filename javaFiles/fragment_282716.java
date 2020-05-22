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