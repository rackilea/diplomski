@Bean
public Step myStep(StepBuilderFactory stepBuilderFactory,
        Tasklet myTasklet,
        PlatformTransactionManager transactionManager) {

    return stepBuilderFactory.get("myStep")
            .tasklet(myTasklet)
            .transactionManager(transactionManager)
            .build();
}