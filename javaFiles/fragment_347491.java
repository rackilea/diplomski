public class DelegateRunningToDiscoverer
{
    public Class<? extends Runner> getDelegateRunningToOn(Class<?> testClass)
    {
        Class<? extends Runner> runnerClass = BlockJUnit4ClassRunner.class;
        DelegateRunningTo annotation = testClass.getAnnotation(DelegateRunningTo.class);

        if(annotation != null)
        {
            runnerClass = annotation.value();
        }

        return runnerClass;
    }
}