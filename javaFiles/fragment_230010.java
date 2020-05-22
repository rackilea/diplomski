final Broadcast<ModelEvaluator> model = jsc.broadcast(new ModelEvaluator(script));

JavaPairRDD<Double, List<Service>> results = cartesian.mapToPair(
        (t) -> {
            try {
                double val = model.value().evaluateModel(t);
                return new Tuple2<>(val, t);
            } catch (Exception ex) {
                return null;
            }
        }
);