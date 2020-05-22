...
WsdlProject project = new WsdlProject( "/path/to/Soapui/project.xml" );
TestSuite testSuite = project.getTestSuiteByName( "testSuiteName" );
TestCase testCase = testSuite.getTestCaseByName( "testCaseName" );
TestRunner runner = test.run(new PropertiesMap(), false );
assertEquals( Status.FINISHED, runner.getStatus() );
// get context and expand the properties
runner.getRunContext().expand("${Test Request#Response}")

....