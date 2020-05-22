@Configuration
public class TestConfig extends WebMvcConfigurationSupport {
   @Override
   public FormattingConversionService mvcConversionService() {
       FormattingConversionService f = super.mvcConversionService();
       f.addConverter(new StringToStreamConverter());
       f.addConverter(new MultipartFileToStreamConverter());
       return f;
   }
}