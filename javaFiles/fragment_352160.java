public class Test {

    public Test() {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStream<String> events = env.readTextFile("datastream.log");

        DataStream<Tuple2<String, JSONObject>> MetaAlert
                = events
                .flatMap(new JSONParser())
                .keyBy(0)
                .timeWindow(Time.seconds(5))
                .apply(new GenerateMetaAlert());

    }

    public class JSONObject {
    }

    public class JSONParser implements FlatMapFunction<String, Tuple2<String, JSONObject>> {
        @Override
        public void flatMap(String s, Collector<Tuple2<String, JSONObject>> collector) throws Exception {

        }
    }

    public class GenerateMetaAlert implements WindowFunction<Tuple2<String, JSONObject>, Tuple2<String, JSONObject>, Tuple, TimeWindow> {
        @Override
        public void apply(Tuple key, TimeWindow timeWindow, Iterable<Tuple2<String, JSONObject>> iterable, Collector<Tuple2<String, JSONObject>> collector) throws Exception {

        }
    }

}