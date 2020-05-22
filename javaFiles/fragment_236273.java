@After
public void afterScenario(Scenario scenario) {
  if (scenario.isFailed()) {
     // Some code to execute...
  }
  if(scenario.isPassed()) {
     // Some code to execute...
  }
}