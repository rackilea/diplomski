@Configuration
@EnableScheduling
public class TaskConfiguration {

  @Bean(destroyMethod = "shutdown")
  public Executor taskScheduler() {
    return Executors.Executors.newFixedThreadPool(4,
        new ThreadFactory() {
          public Thread newThread(Runnable r) {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            t.setDaemon(true);
            return t;
          }
        });
  }

}