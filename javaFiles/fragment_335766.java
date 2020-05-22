public class MyBlockJUnit4ClassRunner extends BlockJUnit4ClassRunner {
  public MyBlockJUnit4ClassRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  @Override
  protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
    System.out.println("before");
    super.runChild(method, notifier);
    System.out.println("after");
  }
}