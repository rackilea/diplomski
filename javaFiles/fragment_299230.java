action(new AbstractTestAction() {
    @Override
    public void doExecute(TestContext context) {
        Long someId = Long.valueOf(context.getVariable("someId"));
        // do something with someId
    }
}