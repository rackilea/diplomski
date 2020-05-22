public class Test {

    public Test() {

        DataStream<Tuple2<String, JSONObject>> MetaAlert
                = events
                .flatMap(new JSONParser())
                .keyBy(new KeySelector<Tuple2<String,JSONObject>, String>() {
                    @Override
                    public String getKey(Tuple2<String, JSONObject> json) throws Exception {
                        return json.f0;
                    }
                })
                .timeWindow(Time.seconds(5))
                .apply(new GenerateMetaAlert());
    }

    public class GenerateMetaAlert implements WindowFunction<Tuple2<String, JSONObject>, Tuple2<String, JSONObject>, String, TimeWindow> {
        @Override
        public void apply(String key, TimeWindow timeWindow, Iterable<Tuple2<String, JSONObject>> iterable, Collector<Tuple2<String, JSONObject>> collector) throws Exception {

        }
    }

}