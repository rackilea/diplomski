// This could be done a number of different ways
public static void main() {
  Injector inj = Guice.createInjector(new MyOuterModule());
  Injector child = inj.createChildInjector(new MyPluginModule(/* interfaceFileName? */));
  MyApp app = child.getInstance(MyApp.class);
  app.run();
}


public class MyPluginModule extends AbstractModule {
  @Override
  protected void configure() {
    MapBinder<String, MyInterface> mapBinder
          = newMapBinder(binder(), String.class, MyInterface.class);
    // These could probably be read from a file with reflection
    mapBinder.addBinding("Foo").to(Foo.class);
    mapBinder.addBinding("Bar").to(Bar.class);
  }
}

public class InterfaceFactory {
  private Pattern p;
  @Inject private Map<Provider<MyInterface>> providerMap;
  private Provider<MyInterface> selectedProvider;

  public void configure(String type, String pattern) {
    p = Pattern.compile(pattern);
    selectedProvider = providerMap.get(type);
  }

  public MyInterface create(String data) {
    if(pattern.matcher(data).find()) {
      MyInterface intf = selectedProvider.get();
      intf.configure(data);
    }
  }
}