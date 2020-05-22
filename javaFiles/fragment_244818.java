@Bean
public MessageSource messageSource()
{
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("messages");
    messageSource.setFallbackToSystemLocale(false);
    messageSource.setCacheSeconds(0);
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
}