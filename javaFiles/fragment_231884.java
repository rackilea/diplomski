public interface ScheduledJob {
    boolean isRepetitive();

    long getDelay();

    void runJob();
}

class Scheduler {
    private final List<ScheduledJob> jobs = new ArrayList<>();

    public void registerJob(ScheduledJob job) {
        jobs.add(job);
    }

    public void runScheduler() {
       // some logic to run all registered jobs
    }
}