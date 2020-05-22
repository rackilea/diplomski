@Bean
public TaskExecutor taskExecutor() {
    return new SimpleAsyncTaskExecutor() {
        @Override
        protected void doExecute(final Runnable task) {
            //gets the jobExecution of the configuration thread
            final JobExecution jobExecution = JobSynchronizationManager.getContext().getJobExecution();
            super.doExecute(new Runnable() {

                public void run() {
                    JobSynchronizationManager.register(jobExecution);

                    try {
                        task.run();
                    } finally {
                        JobSynchronizationManager.close();
                    }
                }
            });
        }
    };
}