public class SomeService extends Service {

  @Inject
  SomeDependency dependency;

  @Override
  public void onCreate() {
    AndroidInjection.inject(this);
    super.onCreate();
  }

  // Do things with your dependencies

}