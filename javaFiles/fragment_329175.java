class MyTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        // get id and name from jobParameters
        // use id and name to do the required work
        return RepeatStatus.FINISHED;
    }
}