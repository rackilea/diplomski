return dynamicTest(currentScenario.getName(), () -> {
  featureElement.run(formatter, reporter, runtime);
  Result result = reporter.getResult(currentScenario);

  // If the scenario is skipped, then the test is aborted (neither passes nor fails).
  Assumptions.assumeFalse(Result.SKIPPED == result);

  Throwable error = result.getError();
  if (error != null) {
    throw error;
  }
});