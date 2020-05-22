@Configuration
@EnableMvc 
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new YearMonthConverter());
    }
}