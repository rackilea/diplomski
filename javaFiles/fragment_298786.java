@Test public void returnsExperimentAsItWasSaved() {
    Experiment original = Experiment.random();
    experimentRepository.save(original);
    flushToDbAndClearCache();

    Experiment fromDb = experimentRepository.findOne(original.getExperimentId());
    assertReflectionEquals(original, fromDb);
}