@Configuration
public class YourConfigFile ...

@Bean
public ICUMessageSource messageSource() {
    ICUReloadableResourceBundleMessageSource messageSource = new ICUReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages/messages");
    messageSource.setCacheSeconds(3600);
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
}