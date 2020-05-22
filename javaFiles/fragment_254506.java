public void restartUncompletedJobs() {
    try {
        jobRegistry.register(new ReferenceJobFactory(job));

        List<String> jobs = jobExplorer.getJobNames();
        for (String job : jobs) {
            Set<JobExecution> runningJobs = jobExplorer.findRunningJobExecutions(job);

            for (JobExecution runningJob : runningJobs) {
                runningJob.setStatus(BatchStatus.FAILED);
                runningJob.setEndTime(new Date());
                jobRepository.update(runningJob);
                jobOperator.restart(runningJob.getId());
                logger.info("Restarted: " + runningJob);
            }
        }
    } catch (Exception e) {
        logger.error(e.getMessage(), e);
    }
}