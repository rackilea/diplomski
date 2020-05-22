@PropertySource("classpath:/dmConfig.properties")
public class DmWebConfigurer extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/index.html").addResourceLocations("/");
        registry.setOrder(Integer.MAX_VALUE-5);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}