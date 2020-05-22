public static JavaRDD<LabeledPoint> filterData(JavaRDD<LabeledPoint> data, String filterString) {
        return data.map(new Function<LabeledPoint, LabeledPoint>() {
            @Override
            public LabeledPoint call(LabeledPoint point) throws Exception {
                double label = point.label();
                double[] features = point.features().toArray();
                String[] featuresInUse = filterString.split(",");
                double[] filteredFeatures = new double[featuresInUse.length];
                for (int i = 0; i < featuresInUse.length; i++) {
                    filteredFeatures[i] = features[Integer.parseInt(VectorizationProperties.getProperty(featuresInUse[i]))];
                }
                LabeledPoint newPoint = new LabeledPoint(label, Vectors.dense(filteredFeatures));
                System.out.println(newPoint);
                return newPoint;
            }
        });
    }