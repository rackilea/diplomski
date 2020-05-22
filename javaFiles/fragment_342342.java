StreamingLinearRegressionWithSGD regressionWithSGD =
                new StreamingLinearRegressionWithSGD()
                        .setInitialWeights(Vectors.zeros(featuresNumber));

        JavaDStream<LabeledPoint> trainingData = streamingContext.textFileStream(model.getTrainPath()).map(LabeledPoint::parse).cache();
        JavaDStream<LabeledPoint> testData = streamingContext.textFileStream(model.getPredictPath()).map(LabeledPoint::parse);
        regressionWithSGD.trainOn(trainingData);
        JavaDStream<Double> doubleJavaDStream=regressionWithSGD.predictOn(testData.map(labeledPoint -> labeledPoint.features()));
        doubleJavaDStream.dstream().saveAsTextFiles("result","out");