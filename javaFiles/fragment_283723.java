public TriggerBuilder<T> forJob(JobDetail jobDetail) {
    JobKey k = jobDetail.getKey();
    if(k.getName() == null)
        throw new IllegalArgumentException("The given job has not yet had a name assigned to it.");
    this.jobKey = k;
    return this;
}