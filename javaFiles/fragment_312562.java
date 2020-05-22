final ExcerptTailer tailer = queue.createTailer();
for (int t = 0; t < 5; t++) {
    long start = System.nanoTime();
    int messages = 100000;
    for (int i = 0; i < messages; i++) {
        try (DocumentContext dc = tailer.readingDocument()) {
            if (!dc.isPresent())
                throw new AssertionError("Missing t: " + t + ", i: " + i);
            ValueIn in = dc.wire().getValueIn();
            String buy = in.text();
            Exchange exchange2 = in.asEnum(Exchange.class);
            CurrencyPair currencyPair2 = in.asEnum(CurrencyPair.class);
            long time = in.int64();
            double price2 = in.float64();
        }
    }
    long time = System.nanoTime() - start;
    System.out.printf("Read Throughput was %,d messages per second%n", (long) (messages * 1e9 / time));
}