@Singleton
@Startup
public class RepeatableService {

    @EJB
    private SomeService service;

    @Resource
    private TimerService timerService;

    private long repeatInterval = 1234000L; // in milliseconds

    @PostConstruct
    public void init() {
        timerService.createIntervalTimer(0L,
                repeatInterval, new TimerConfig(null, false));
    }

    @Timeout
    public void process(Timer timer) {
        doAction();
    }

    public void doAction() {
        System.out.println("Action called!");
        service.someAction();
    }

}