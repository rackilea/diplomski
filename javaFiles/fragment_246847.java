public class MyRunner extends BlockJUnit4ClassRunner {
    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        Description description= describeChild(method);
        if (method.getAnnotation(Ignore.class) != null) {
            notifier.fireTestIgnored(description);
        } else {
            RunRules runRules = new RunRules(methodBlock(method), Arrays.asList(new TestRule[]{new RetryTestRule(3)}), description);
            runLeaf(runRules, description, notifier);
        }
    }
}