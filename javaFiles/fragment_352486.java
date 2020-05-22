public class TestRunner extends BlockJUnit4ClassRunner
{
    public TestRunner(Class<?> klass) throws InitializationError
    {
         super(klass);
    }

    @Override
    public void run(RunNotifier notifier)
    {
        notifier.addListener(new TestLogger()); 
        super.run(notifier);
    }
}