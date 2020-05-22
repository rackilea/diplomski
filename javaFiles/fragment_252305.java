messages.stream()
    .mapToLong(Message::getOffset)
    .sorted()
    .forEachOrdered(new LongConsumer() {
        boolean first=true;
        long expected;
        public void accept(long value) {
            if(first) first=false;
            else if(value!=expected)
                LOG.error("Missing offset(s) found in messages: missing from {} to {}",
                          expected, value);
            expected=value+1;
        }
    });