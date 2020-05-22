public JobDetail retrieveJob(JobKey jobKey) {
    synchronized(lock) {
        JobWrapper jw = jobsByKey.get(jobKey);
        return (jw != null) ? (JobDetail)jw.jobDetail.clone() : null;
    }
}