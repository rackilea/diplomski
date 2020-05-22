List<JobInstance> jobInstances = jobExplorer.getJobInstances(jobName);

for (JobInstance jobInstance : jobInstances) {
    List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
    for (JobExecution jobExecution : jobExecutions) {
        if (//jobExecution.getWhatever...)) {
        // do your thing...
        }
     }
}