@Bean
public Step personLoadingStep() {
    return steps.get("personLoadingStep")
            .tasklet((contribution, chunkContext) -> {
                System.out.println("personLoadingStep");
                chunkContext.getStepContext().getStepExecution().setExitStatus(new ExitStatus("INVALID"));
                return RepeatStatus.FINISHED;
            })
            .build();
}