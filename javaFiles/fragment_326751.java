public class ChatClient {
  // Defined and wired as RmiProxyFactoryBean in applicationContext.xml
  private ChatService chatService;

  private ScheduledExecutorService scheduleTaskService;

  ... ...

  // At some point during chat application running life cyle:
  scheduleTaskService = Executors.newScheduledThreadPool(5);

  // This schedule pooling task to run every 2 minutes:
  scheduleTaskService.scheduleAtFixedRate(new Runnable() {
    public void run() {
      // Pooling server using RMI call:
      chatService.poolingData();
    }
  }, 0, 2, TimeUnit.MINUTES);

  ... ...

}