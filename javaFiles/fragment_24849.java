@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gmail.nlpraveennl") //Do not skip componentscan
public class ServletConfiguration implements WebMvcConfigurer
{
     @Bean
     public ViewResolver configureViewResolver() 
     {
         InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
         viewResolve.setPrefix("/WEB-INF/jsp/");
         viewResolve.setSuffix(".jsp");

         return viewResolve;
     }

    @Bean
    public ResourceBundleMessageSource messageSource()
    {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}