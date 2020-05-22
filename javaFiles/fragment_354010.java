public class MySchduler {
    private final ScheduledExecutorService scheduler =
                     Executors.newScheduledThreadPool(1);
    public static void main(String[] args) {
        scheduler.scheduleAtFixedRate(new TaskRunner(), 0, 1, TimeUnit.DAYS);
    }
}