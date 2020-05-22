@Bean
JobLauncher jobLauncher(JobRepository jobRepository) {
    new SimpleJobLauncher(
            taskExecutor: taskExecutor(),
            jobRepository: jobRepository)
}