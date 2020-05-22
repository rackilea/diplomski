KStreamBuilder builder = new KStreamBuilder();

// Add the countStore that will be used within the Transformer[Supplier]
// that we pass into `transform()` below.
builder.addStateStore(countStore);

KStream<byte[], String> input = builder.stream("source-topic");

KStream<String, Long> transformed =
    input.transform(/* your TransformerSupplier */, countStore.name());