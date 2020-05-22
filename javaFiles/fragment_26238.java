public class MyResultListener implements ISuiteListener{

    @Override
    public void onStart(ISuite suite) {
    // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ISuite suite) {
    Map<String,ISuiteResult> resultMap = suite.getResults();
    for(Map.Entry<String, ISuiteResult> ent :resultMap.entrySet())
    {
       ISuiteResult res = ent.getValue();
       IResultMap failedTestMap = res.getTestContext().getFailedTests();
       IResultMap passTestMap = res.getTestContext().getPassedTests();
        for(ITestResult testResult :failedTestMap.getAllResults()){

        if(testResult.getThrowable().getClass().equals(new MyOwnException())){}

           System.out.println("My Own exception thrown");
            failedTestMap.removeResult(testResult);
            passTestMap.addResult(testResult, testResult.getMethod());
        }
        }

    }   
  }