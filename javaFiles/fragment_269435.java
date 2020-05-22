@Bean
public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/messages/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;