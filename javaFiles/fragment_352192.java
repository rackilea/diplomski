/**
 * @param stepBuilderFactory   step for run each partition
 * @return Step step 6 partition match
 */
@Profile({SINGLE, SLAVE})  //Not applicable for MASTER profile in remote partitioning case
@Bean("slaveStep")
public Step slaveStep(StepBuilderFactory stepBuilderFactory,
                               @Qualifier("readFromFileFlow") Flow flow
) {
    return stepBuilderFactory.get("slaveStep")
            .listener(stepListener())
            .flow(flow)
            .build();
}

@Profile({SINGLE, SLAVE})
@Bean
public ChildSlaveListener stepListener(){
    return new ChildSlaveListener();
}

@Profile({SINGLE, SLAVE})
@Bean("readFromFileFlow")
public Flow readFromFileFlow(@Qualifier("childSlaveStep1") Step childSlaveStep1,
                             @Qualifier("childSlaveStep2") Step childSlaveStep2) {
    // @formatter:off
    return new FlowBuilder<Flow>("readFromFileFlow")
            .start(childSlaveStep1)
            .on(FAILED).fail()
            .from(childSlaveStep1)
            .on(COMPLETED).to(childSlaveStep2)
            .start(childSlaveStep2)
            .on(FAILED).fail()
            .from(childSlaveStep2)
            .on(COMPLETED).end()
            .end();
    // @formatter:on
}