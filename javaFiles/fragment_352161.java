DataStream<Tuple2<String, JSONObject>> MetaAlert
        = events
        .flatMap(new JSONParser())
        .keyBy(0)
        .timeWindow(Time.seconds(5))
        .apply(new WindowFunction<Tuple2<String, JSONObject>, Tuple2<String, JSONObject>, Tuple, TimeWindow>() {
            @Override
            public void apply(Tuple tuple, TimeWindow timeWindow, Iterable<Tuple2<String, JSONObject>> iterable, Collector<Tuple2<String, JSONObject>> collector) throws Exception {
                // Your code here
            }
        });