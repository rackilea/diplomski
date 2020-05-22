@Component
class TestScheduler{

    @Scheduled(cron = "${cronexpression}")
    public void scheduledjob() {
        System.out.println("Scheduler is running");
    }

}