public boolean shouldDoWork(Work work) {
    synchronized(myJobs) {
        return !myJobs.stream()
              .map(job -> job.doWork(work))
              .anyMatch(shouldDoWork -> !shouldDoWork);
    }
}

public addJob(Job job) {
    synchronized (myJobs) {
        myJobs.add(job);
    }
}