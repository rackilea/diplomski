@Bean
public MessageSource businessMessageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
                                               new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/messages/business/message");

    return messageSource;
}

@Bean
public MessageSource validationMessageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
                                               new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/messages/validation/message");

    return messageSource;
}

@Bean
public MessageSource viewMessageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
                                               new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/messages/view/message");

    return messageSource;
}