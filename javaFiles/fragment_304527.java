@SpringBootApplication
@ComponentScan("de. ... .analysis")
@EntityScan("de. ... .persistence")
@EnableJpaRepositories("de. ... .persistence.repositories")
@EnableAutoConfiguration
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class Main {

    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static SpringApplication application = new SpringApplication(Main.class);

    private TaskScheduler taskScheduler;

    private AnalysisProcessingThread processingThread;

    private AnalysisCleaningThread cleaningThread;


    @Inject
    public void setProcessingThread(AnalysisProcessingThread processingThread) {
        this.processingThread = processingThread;
    }

    @Inject
    public void setCleaningThread(AnalysisCleaningThread cleaningThread) {
        this.cleaningThread = cleaningThread;
    }

    @Inject
    public void setTaskScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public static void main(String[] args)
            throws Exception {

        try {

            //Do some setup

            application.run(args);

        } catch (Exception e) {

            LOGGER.error(e.getMessage(), e);
        }
    }

    @PostConstruct
    public void init() throws Exception {

        //Do some other setup

    }

    @EventListener(ApplicationReadyEvent.class)
    public void startAndScheduleTasks() {
        ScheduledFuture scheduledFuture = null;
        LOGGER.info("********** Scheduling one time Cleaning Thread. Starting in 5 seconds **********");
        Date nowPlus5Seconds = Date.from(LocalTime.now().plus(5, ChronoUnit.SECONDS).atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        scheduledFuture = this.taskScheduler.schedule(this.cleaningThread, nowPlus5Seconds);
        try {
            scheduledFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("********** Cleaning Thread did not finish as expected! Stopping thread. Dirty analyses may still remain in database **********", e);
            scheduledFuture.cancel(true);
        }
  }
}