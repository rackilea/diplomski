public class App {

    public static void main(String[] args) {
        final Runnable jobToExecute = () -> System.out.println("Doing something on " + new Date());

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        ScheduledFuture future = executorService.schedule(jobToExecute, diffInSeconds(LocalDateTime.of(2017, 5, 30, 23, 54, 00)), TimeUnit.SECONDS);
    }

    private static long diffInSeconds(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC) - LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
}