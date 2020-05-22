@Configuration
public class LocalizationConfiguration {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messages = new ReloadableResourceBundleMessageSource();
        messages.setBasenames("classpath:beanValidation", "classpath:errors");
        messages.setDefaultEncoding("UTF-8");
        return messages;
    }

}