public class MyMethodInvoke implements IInvokedMethodListener {

    private int failure = 0;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        int testCount = testResult.getTestContext().getAllTestMethods().length; 
        if((failure * 1.0) / testCount > 0.3)
            throw new SkipException("Crossed the failure rate");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {        
        if(testResult.getStatus()==ITestResult.FAILURE)
            failure++;
    }

}