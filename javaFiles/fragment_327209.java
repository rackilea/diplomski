@Bean
@JobScope
@Qualifier("step1")
public Step stepOne() throws StepException {
    SimpleStepBuilder<StepOneInput, StepOneOutput> builder = stepBuilderFactory.get("step1")
            .<StepOneInput, StepOneOutput>chunk(configAccess.getChunkSize())
            // setting up listener for Read/Process/Write
            .listener((ItemProcessListener<? super StepOneInput, ? super StepOneOutput>) listener)
            .faultTolerant()
            // setting up listener for skipPolicy
            .skipPolicy(listener)
            .reader(reader.read())
            .processor(processor.compose())
            .writer(writer);

    // for step execution listener
    builder.listener((StepExecutionListener)listener);

    return builder.build();
}