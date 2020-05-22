@Component
public class AppLifecycle implements SmartLifecycle {

    private Logger log = LoggerFactory.getLogger(AppLifecycle.class);

    @Autowired
    private SampleService sampleService;

    @Override

    public boolean isAutoStartup() {
        log.debug("=========================auto startup=========================");
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        sampleService.getSessionMap().forEach((key, session) -> {
            try {
                session.close(CloseStatus.SERVICE_RESTARTED);
                log.debug("disconnecting : {}", key);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        });
        log.debug("=========================stop runnable=========================");
        new Thread(runnable).start();
    }

    @Override
    public void start() {
        log.debug("=========================start=========================");
    }

    @Override
    public void stop() {
        log.debug("=========================stop=========================");
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }
}