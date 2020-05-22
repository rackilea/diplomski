@Configuration
public class WebAutoConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters( final FormatterRegistry registry ) {

        registry.addConverter(
                String.class,
                MyEnum.class,
                new EnumCaseInsensitiveConverter<>( MyEnum.class )
        );
    }
}