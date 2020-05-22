action(new AbstractTestAction() {
    @Override
    public void doExecute(TestContext context) {
        loggingService.log("Now called custom logging service");
    }
});