DataFrame training = sqlContext.createDataFrame(sc.parallelize(
        Arrays.asList(
            new LabeledPoint(1.0, Vectors.dense(0.0, 1.1, 0.1)),
            new LabeledPoint(0.0, Vectors.dense(2.0, 1.0, -1.0)),
            new LabeledPoint(0.0, Vectors.dense(2.0, 1.3, 1.0)),
            new LabeledPoint(1.0, Vectors.dense(0.0, 1.2, -0.5))
        )
    ), LabeledPoint.class);