AssignerWithPunctuatedWatermarks eventTimeFunction = new AssignerWithPunctuatedWatermarks<MyEvent>() {
    long maxTs = 0;

    @Override
    public long extractTimestamp(MyEvent myEvent, long l) {
        long ts = myEvent.getEventTime();
        if (ts > maxTs) {
            maxTs = ts;
        }
        return ts;
    }

    @Override
    public Watermark checkAndGetNextWatermark(MyEvent event, long extractedTimestamp) {
        return new Watermark(maxTs - 10000);
    }
};