public void process(JCas aJCas) throws AnalysisEngineProcessException {
    List<TOP> tops = new ArrayList<TOP>(JCasUtil.selectAll(aJCas));
    List<String> manufacturers = new ArrayList<>();
    for (TOP t : tops) {
        if (t.getType().getName().endsWith("ColoredCar")) {
            Feature carsFeature = t.getType().getFeatureByBaseName("cars");
            FSArray fsArray = (FSArray) t.getFeatureValue(carsFeature);
            FeatureStructure[] arrayStructures = fsArray.toArray();
            for (int i = 0; i < arrayStructures.length; i++) {
                FeatureStructure fs = arrayStructures[i];
                Feature manufacturerFeature = fs.getType().getFeatureByBaseName("cars");
                manufacturers.add(fs.getStringValue(manufacturerFeature) );
            }
        }
    }
}