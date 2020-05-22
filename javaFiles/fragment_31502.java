@SpringBootApplication
@EnableScheduling
public class App implements SchedulingConfigurer {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final AtomicInteger ctxCount = new AtomicInteger();

    private static final String[] accounts = { "user1", "user2", "user3" };

    public static void main(String[] args) {

        Arrays.stream(accounts).forEach(account -> {
            ConfigurableApplicationContext context = SpringApplication.run(App.class, account);
            context.getBeanFactory().getBean(MyService.class, account);
        });
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskScheduler() {
        // https://github.com/spring-projects/spring-boot/issues/7779
        final String prefix = "app-" + ctxCount.incrementAndGet() + "-mcsch-";
        log.debug("Creating task scheduler {}", prefix);
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix(prefix);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setAwaitTerminationSeconds(20);
        return scheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        log.debug("Setting task scheduler.");
        taskRegistrar.setScheduler(taskScheduler());
    }

    @Service
    @Lazy
    static class MyService {

        private String account;

        public MyService(String account) {
            log.debug("{} - MyService constructor", account);
            this.account = account;
        }

        // trick to "run at startup"
        @Scheduled(initialDelay = 0L, fixedDelay = Long.MAX_VALUE)
        public void run() {
            boolean stopped = false;
            while(!stopped) {
                try {
                    log.debug("{} - sleeping", account);        
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.debug("{} - sleep interrupted", account);
                    stopped = true;
                }
            }
            log.debug("{} - finished gracefully", account);
        }
    } // MyService

}