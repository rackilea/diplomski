WsdlTestCaseRunner runner = new WsdlTestCaseRunner((WsdlTestCase) testCase, new StringToObjectMap(testCase.getProperties()) );
for(TestStep testStep: testSteps){
      //calling the above get method here
      String response = runStepAndGetResponseContent(runner, testStep);
      System.out.print("Received response is :" + response);
}