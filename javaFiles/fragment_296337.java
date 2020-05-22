StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

DataStream<Event> input = ...

input.assignTimestampsAndWatermarks(new AscendingTimestampExtractor<Event>() {

    @Override
    public long extractAscendingTimestamp(MyEvent element) {
        return value.getSomeTimeField();
    }
})

CEP.pattern(input, pattern).select(...)