public class Activator {
  private ServiceRegistration goldenFrameworkSR;

  @Override
  public void start(BundleContext context) {
    goldenFrameworkSR = context.registerService(GoldenFrameworkOSGi.class, new GoldenFrameworkOSGi(), new HashTable());
  }

  @Override
  public void stop(BundleContext context) {
    goldenFrameworkSR.unregister();
  }
}