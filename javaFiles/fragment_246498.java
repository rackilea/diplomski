public class Main {
    private static boolean canStop=false;

    private static void stopPHPDataChecker() {
        canStop=true;
    }

    public static void main(String[] args) {
        // Setup a task for checking data and then schedule it
        PHPDataChecker pdc = new PHPDataChecker();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final ScheduledFuture<?> pdcHandle = scheduler.scheduleAtFixedRate(pdc, 0L, 5L, TimeUnit.MINUTES);// Start pooling

        // Setup a new task to kill the polling after 25 minutes
        scheduler.schedule(new Runnable() {

            public void run() {
                System.out.println(">> TRY TO STOP!!!");
                pdcHandle.cancel(true);
                Main.stopPHPDataChecker();
                System.out.println("DONE");
            }

        }, 25L, TimeUnit.MINUTES);

        // Actively wait stop condition (canStop)
        do {
            if (canStop) {
                scheduler.shutdown();
            }
        } while (!canStop);

        System.out.println("END");
    }
}