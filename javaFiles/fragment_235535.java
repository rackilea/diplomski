import static java.util.concurrent.TimeUnit.*;
class BeeperControl {
private final ScheduledExecutorService scheduler =
       Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() { System.out.println("beep"); }
            };
        final ScheduledFuture<?> beeperHandle =
            scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
                public void run() { beeperHandle.cancel(true); }
            }, 60 * 60, SECONDS);
    }
 }