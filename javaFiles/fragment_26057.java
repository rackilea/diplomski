@Singleton
@Startup
public class StartWhenDeploy {

    private static final int PERIOD = 3000;

    // Inject the TimerService into this EJB
    @Resource
    private TimerService timer;

    private TimerAction action;

    @PostConstruct
    public void init() {
        System.out.println("I will set information to start my task");
        // the action object is created before the timer
        action = new TimerAction(1);
        timer.createTimer(new Date(), PERIOD, "My timer");
    }

    // this method will be executed when the timer fires - it needs to wrap your `TimerAction` created once per this singleton instance (`TimerAction` does not have to extend `TimerTask` now)
    @Timeout
    public void runTimerAction() {
        action.run();
    }

}