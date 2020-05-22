public static class AverageTempMapper extends RichFlatMapFunction<Tuple2<String, MqttTemperature>, Tuple2<String, Double>> {

    private static final long serialVersionUID = -4780146677198295204L;
    private ValueState<Tuple2<Integer, Double>> modelState;

    @Override
    public void open(Configuration parameters) {
        this.modelState = getRuntimeContext().getState(new ValueStateDescriptor<>("modelState", TupleTypeInfo.getBasicTupleTypeInfo(Integer.class, Double.class)));
    }

    @Override
    public void flatMap(Tuple2<String, MqttTemperature> value, Collector<Tuple2<String, Double>> out) throws Exception {
        Double temp;
        Integer count;
        if (modelState.value() != null) {
            Tuple2<Integer, Double> state = modelState.value();
            count = state.f0 + 1;
            temp = state.f1 + value.f1.getTemp();
        } else {
            count = 1;
            temp = value.f1.getTemp();
        }
        modelState.update(Tuple2.of(count, temp));

        if (count >= 3) {
            out.collect(Tuple2.of(value.f0, temp/count));
        }
    }
}