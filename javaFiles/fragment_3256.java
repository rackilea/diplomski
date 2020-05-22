public class MyScheduler {

    @Autowired
    private TaskScheduler scheduler;

    public void scheduleNewCall(Date dateTime) {
        scheduler.schedule(this::scheduledMethod, dateTime);
    }

    public void scheduledMethod() {
    // method that you wish to run
    }

}