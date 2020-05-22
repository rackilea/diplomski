@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.removeConvertible(String.class,Collection.class);
    registry.addConverter(String.class,Collection.class,myConverter);
  }
}