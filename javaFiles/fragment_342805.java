private void accumulateTwo(KStream<String, String> messages) {
    messages.transform(new PairTransformerSupplier<>())
            .filter((key, value) -> value != null)
            .mapValues(Pair::toString)
            .to("pairs");
}