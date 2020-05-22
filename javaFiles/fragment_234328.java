@Configuration
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverterFactory(new CaseInsensitiveStringToEnumConverterFactory());
  }
}