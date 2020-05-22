@Service
public class Service {
    private static final Logger log = LoggerFactory.getLogger(Service.class);
    private final TaskScheduler scheduler;

    @Autowired
    public Service(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void startTask(int inteval) {
        scheduler.schedule(() -> log.info("Doing work"), triggerContext -> {
            if (some_condition) {
                ZonedDateTime now = ZonedDateTime.now();

                return Date.from(now.plusSeconds(interval).toInstant());
            } else {
                // Stop the execution
                return null;
            }
        });
    }
}