return stepBuilderFactory
        .get("partitionedStepOne")
        .partitioner(stepOne)
        .partitioner("partition", partitioner())
        .listener(partitioner())
        .taskExecutor(someExecutor())
        .gridSize(SIZE)
        .build();