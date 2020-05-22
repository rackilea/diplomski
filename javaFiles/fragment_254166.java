@Listeners({Testing.MethodInterceptor.class})
public class Testing {

    @BeforeClass
    public void b4class(){
        System.out.println("b4class");
    }

    @Test
    protected void t1(){
        System.out.println("t1");
        throw new IllegalArgumentException("BOOM");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    public static class MethodInterceptor implements IInvokedMethodListener {

        int status = ITestResult.SUCCESS;

        @Override
        public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
            if (method.isConfigurationMethod()
                    && method.getTestMethod().getMethodName().equals("afterClass")
                    && ITestResult.FAILURE == status) {
                throw new IllegalStateException("BIG BOOM");
            }
        }

        @Override
        public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
            if (method.getTestMethod().getMethodName().equals("t1")) {
                status = testResult.getStatus();
            }
        }
    }
}