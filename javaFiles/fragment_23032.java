compile "com.github.akarnokd:rxjava2-extensions:0.17.5"

Flowable.just("1", "2", "#", "3", "#", "4", "#")
.compose(FlowableTransformers.bufferUntil(v -> "#".equals(v)))
.test()
.assertResult(
    Arrays.asList("1", "2", "#"),
    Arrays.asList("3", "#"),
    Arrays.asList("4", "#")
);