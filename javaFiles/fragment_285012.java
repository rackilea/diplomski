public class App extends Application implements HasActivityInjector, HasServiceInjector {

  @Inject
  DispatchingAndroidInjector<Activity> activityInjector;
  @Inject
  DispatchingAndroidInjector<Service> serviceInjector;

  @Override
  public void onCreate() {
    super.onCreate();
    AppInjector.init(this);
  }

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return activityInjector;
  }

  @Override
  public AndroidInjector<Service> serviceInjector() {
    return serviceInjector;
  }
}