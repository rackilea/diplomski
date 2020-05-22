StringBuffer predictionSB = new StringBuffer();
Range attributesToShow = null;
Boolean outputDistributions = new Boolean(true);

PlainText predictionOutput = new PlainText();
predictionOutput.setBuffer(predictionSB);
predictionOutput.setOutputDistribution(true);

Evaluation evaluation = new Evaluation(data);
evaluation.crossValidateModel(j48Model, data, numberOfFolds,
        randomNumber, predictionOutput, attributesToShow,
        outputDistributions);