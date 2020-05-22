@Bean
public MessageSource messageSource1() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    messageSource.setBasename("classpath:i18n/messages1");
    messageSource.setFallbackToSystemLocale(false);
    messageSource.setCacheSeconds(0);

    return messageSource;
}

@Bean
public MessageSource messageSource2() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    messageSource.setBasename("classpath:i18n/messages2");
    messageSource.setFallbackToSystemLocale(false);
    messageSource.setCacheSeconds(0);

    return messageSource;
}