@Configuration
 @EnableScheduling
 public class AppConfig implements SchedulingConfigurer {

     [...]

     @Bean(destroyMethod="shutdown", name = "taskSchedulerA")
     public Executor taskSchedulerA() {
         return Executors.newScheduledThreadPool(42);
     }
     @Bean(destroyMethod="shutdown", name = "taskSchedulerB")
     public Executor taskSchedulerA() {
         return Executors.newScheduledThreadPool(42);
     }
 }


 @Service
 public class MyService {
      @Autowired @Qualifier("taskSchedulerA")
      private Executor taskSchedulerA; 
      @Autowired @Qualifier("taskSchedulerB")
      private Executor taskSchedulerB; 

      @PostConstruct
      public void schedule(){
        Executors.newScheduledThreadPool(42).schedule(new Runnable() {
          @Override
          public void run() {
            functionOfGroupA();
          }
    } , ..);

      }
 }