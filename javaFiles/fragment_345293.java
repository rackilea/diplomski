public class TaskRunner{

private static final ScheduledExecutorService taskScheduler = Executors.newScheduledThreadPool(1);

  public static void main(String[] args) {
    taskScheduler.scheduleWithFixedDelay(new MyTask(),0,5,TimeUnit.MINUTES);  
  }

}