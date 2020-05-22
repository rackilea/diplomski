KStream<String, String> source = builder.stream("streams-plaintext-input");

source.print(Printed.toSysOut());
KTable<String, Long> counts = source
    .flatMapValues(new ValueMapper<String, Iterable<String>>() {
...