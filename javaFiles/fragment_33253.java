private ConcurrentHashMap<Job, Job> myJobs = new ConcurrentHashMap<>();

public boolean shouldDoWork(Work work) {
    return !myJobs.keySet().stream()
          .map(job -> job.doWork(work))
          .anyMatch(shouldDoWork -> !shouldDoWork);
}

public addJob(Job job) {
    myJobs.put(job, job);
}