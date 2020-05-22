double[] predictionDistribution = null;
    try {
        double clsLabel = classifier.classifyInstance(Test Instance Here);
        predictionDistribution = classifier.distributionForInstance(Test Instance Here);
    } catch (Exception e) {
        System.out.println("Unable to classify item\n");
    }