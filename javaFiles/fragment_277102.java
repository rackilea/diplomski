public class TestMethodsDisabler implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> testsToRun = new ArrayList<>();

        for (IMethodInstance method : methods) {
            Test testClass = method.getInstance()
                .getClass()
                .getAnnotation(Test.class);

            if (testClass == null || testClass.enabled()) {
                testsToRun.add(method);
            }
        }

        return testsToRun;
    }
}