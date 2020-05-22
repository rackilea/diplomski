@EnableAsync
public class Example {

  @Async
  @Scheduled(fixedRate = 1000)
  public void schedule1() throws InterruptedException {
    Thread.sleep(5000);
  }
}