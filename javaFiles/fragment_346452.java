ProcessorSelector<IN, OUT> selector = new ProcessorSelector<IN, OUT>();

selector = selector.when(predicate1).then(p1)
    .when(predicate2).then(p2)
    .otherwise(defaultProcessor);

final Processor<IN, OUT> processor = selector.getProcessor();