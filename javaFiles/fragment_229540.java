public class AppConfig extends ResourceConfig {
    public AppConfig() {
         register(new AbstractBinder() {
              @Override
              protected void configure() {
                  bind(MyAnnotationParamValueProvider.class)
                       .to(ValueFactoryProvider.class)
                       .in(Singleton.class);
              }
         });
    }
}