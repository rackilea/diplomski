private static double getConfidenceScore(
            final LogisticRegressionModel lrModel, final Vector vector) {
        /* Approach to get confidence scores starts */
        Vector weights = lrModel.weights();
        int numClasses = lrModel.numClasses();
        int dataWithBiasSize = weights.size() / (numClasses - 1);
        boolean withBias = (vector.size() + 1) == dataWithBiasSize;
        double maxMargin = 0.0;
        double margin = 0.0;
        for (int j = 0; j < (numClasses - 1); j++) {
            margin = 0.0;
            for (int k = 0; k < vector.size(); k++) {
                double value = vector.toArray()[k];
                if (value != 0.0) {
                    margin += value
                            * weights.toArray()[(j * dataWithBiasSize) + k];
                }
            }
            if (withBias) {
                margin += weights.toArray()[(j * dataWithBiasSize)
                        + vector.size()];
            }
            if (margin > maxMargin) {
                maxMargin = margin;
            }
        }
        double conf = 1.0 / (1.0 + Math.exp(-maxMargin));
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        double confidenceScore = Double.valueOf(twoDForm.format(conf * 100));
        /* Approach to get confidence scores ends */
        return confidenceScore;
    }