@Before
public void setTheStage(final Scenario scenario) {
    final StepEventBus eventBus = StepEventBus.getEventBus();
    if (scenario.getSourceTagNames().contains("@Unimplemented") && !eventBus.currentTestIsSuspended()) {
        eventBus.suspendTest(TestResult.IGNORED);
    }