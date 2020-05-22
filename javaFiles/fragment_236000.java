public class MyRunner extends BlockJUnit4ClassRunner {
    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        // run your code here. example:
        Runner.value = true;            

        super.runChild(method, notifier);
    }
}