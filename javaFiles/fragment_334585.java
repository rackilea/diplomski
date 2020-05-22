@Bean
public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
                                               new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath:/messages/business/message", 
                               "classpath:/messages/validation/message",
                               "classpath:/messages/view/message");

    return messageSource;
}