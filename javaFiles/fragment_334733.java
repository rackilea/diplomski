@Then("the client receives a response with {string}")
public void the_client_receives_a_response_with(String payload) {
    designer.action(new AbstractTestAction() {
        public void doExecute(TestContext context) {
            Assert.assertTrue(context.getMessageStore()
                                         .getMessage("currentMessage")
                                         .getPayload(String.class)
                                         .equals(payload));
        }
    });
}