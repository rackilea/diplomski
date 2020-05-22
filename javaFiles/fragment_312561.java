String path = OS.getTarget();
ChronicleQueue queue = SingleChronicleQueueBuilder.binary(path + "/market").build();
ExcerptAppender appender = queue.acquireAppender();
Exchange exchange = Exchange.EBS;
CurrencyPair currencyPair = CurrencyPair.EURUSD;
double price = 1.2345;
for (int t = 0; t < 5; t++) {
    long start = System.nanoTime();
    int messages = 100000;
    for (int i = 0; i < messages; i++) {
        try (DocumentContext dc = appender.writingDocument()) {
            ValueOut valueOut = dc.wire().getValueOut();
            valueOut.text("buy")
                    .getValueOut().asEnum(exchange)
                    .getValueOut().asEnum(currencyPair)
                    .getValueOut().int64(System.currentTimeMillis())
                    .getValueOut().float64(price);
        }
    }
    long time = System.nanoTime() - start;
    System.out.printf("Throughput was %,d messages per second%n", (long) (messages * 1e9 / time));
    Jvm.pause(100);
}