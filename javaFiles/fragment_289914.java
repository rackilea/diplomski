Flowable.fromArray("The", "quick", "brown", "fox", "jumps",
    "over", "the", "lazy", "dog.",
    "This", "sentence", "is", "false.")
.compose(FlowableTransformers.bufferUntil(v -> v.endsWith(".")))
.map(list -> Strings.join(" ", list))
.test()
.assertResult(
    "The quick brown fox jumps over the lazy dog.",
    "This sentence is false."
);