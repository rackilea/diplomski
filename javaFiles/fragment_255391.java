import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CancellableTaskDemo {
    public static void main(final String[] args) {
        new CancellableTaskDemo();
    }

    final ExecutorService ex = Executors.newFixedThreadPool(3);

    public CancellableTaskDemo() {
        for (int i = 0; i < 10; i++) {
            final int c = i;
            submitTask(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    final long t = System.currentTimeMillis();
                    try {
                        Thread.sleep(2000);
                        System.out.println("Task " + c + " done in " + (System.currentTimeMillis() - t) + "ms");
                    } catch (final InterruptedException e) {
                        System.out.println("Task " + c + " aborted after " + (System.currentTimeMillis() - t) + "ms");
                    }
                    return null;
                }
            }, 1000);
        }
        ex.shutdown();
        try {
            ex.awaitTermination(100000, TimeUnit.MILLISECONDS);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void submitTask(final Callable<Object> c, final int timeout) {
        final TimedFutureTask tft = new TimedFutureTask(c, timeout);
        final Future<?> ft = ex.submit(tft.getCallable());
        tft.setFuture(ft);
    }

    static class TimedFutureTask {
        final static ScheduledExecutorService canceller = Executors.newSingleThreadScheduledExecutor();
        private Timer cancelTimer;
        private Callable<Object> timedCallable;
        private Future<?> f;
        private int timeoutMS;

        public TimedFutureTask(final Callable<Object> callable, final int timeoutMS) {
            this.timeoutMS = timeoutMS;
            timedCallable = (new Callable<Object>() {

                @Override
                public Object call() throws Exception {

                    cancelTimer = new Timer();
                    cancelTimer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            f.cancel(true);

                        }
                    }, timeoutMS);

                    final Object res = callable.call();
                    cancelTimer.cancel();
                    return res;
                }

            });
        }

        public Callable<Object> getCallable() {
            return timedCallable;
        }

        public void setFuture(final Future<?> future) {
            f = future;
        }
    }

}