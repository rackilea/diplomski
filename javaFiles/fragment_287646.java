public String runStepAndGetResponseContent(WsdlTestCaseRunner runner, TestStep testStep) {
        TestStepResult result = runner.runTestStep(testStep);
        if (result instanceof WsdlTestRequestStepResult) {
            return ((WsdlTestRequestStepResult) result).getResponse().getContentAsString();
        }
        return null;
}