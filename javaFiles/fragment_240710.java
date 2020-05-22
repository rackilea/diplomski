@RestController
public class SomeTask {

    private SomeService someService;
    private final AtomicBoolean isTriggered = new AtomicBoolean();

    @Autowired
    public SomeTask(SomeService someService) {
        this.someService = someService;
    }

    @Async // requirement 1
    @RequestMapping(method = RequestMethod.POST, path = "/triggerJob")
    public void triggerJob() {
        if (!isTriggered.getAndSet(true)) {
            try {
                expensiveLongRunningJob();
            } finally {
                isTriggered.set(false);
            }
        }
    }

    /**
     * only runs once at a time, in the thread that sets isTriggered to true
     */
    private void expensiveLongRunningJob() { 
        someService.executedJob();
    }
}