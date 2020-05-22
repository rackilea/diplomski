public class HuracanModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(HuracanCar.class).to("sports car");
        bind(URL.class).annotatedWith(HuracanCar.class).
          toInstance(new URL("www.lamborghini.com"));
    }   
}