@Startup
@Singleton
public class SyncTimer {
    private static final long HOUR = 60 * 60 * 1000L;

    @Resource
    private TimerService timerService;
    private Timer timer;

    @PostConstruct
    public void init() {
        TimerConfig config = new TimerConfig();
        config.setPersistent(false);
        timer = timerService.createIntervalTimer(HOUR, HOUR, config);
    }

    @Timeout
    private synchronized void onTimer() {
        // every hour action
    }
}