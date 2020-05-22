public class YourModule extend AbstractModule {
  @Override public void configure() {
    // You can get a Provider in a Module as long as you
    // don't call get() before the injector exists.
    Provider<Settings> settingsProvider = binder().getProvider(Settings.class);
    for (Config config : Config.values()) {
      String propertyName = config.getPropertyName();
      // Guice's TypeConverter will convert Strings to the right type.
      bind(String.class).annotatedWith(config.annotation()).toProvider(
          new GetValueFromSettingsProvider(settingsProvider, propertyName));
    }
  }
}