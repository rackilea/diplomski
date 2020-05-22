@Override
public Validator getValidator() {
    return validator();
}

@Bean
public LocalValidatorFactoryBean validator() {
    final LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
    validator.setValidationMessageSource(messageSource());
    return validator;
}

/**
 * @title:messageSource:base name sequence:i18n and bean validation use this
 * [baseName]_[language]_[script]_[region]_[variant]
 * [baseName]_[language]_[script]_[region]
 * [baseName]_[language]_[script]
 * [baseName]_[language]_[region]_[variant]
 * [baseName]_[language]_[region]
 * [baseName]_[language]
 * @return MessageSource
 * @create 2018-09-25 09:32:24
 * @author:elf
 * @since:1.0.0
 */
@Bean
public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
    String[] baseNameArray = {
        "classpath:i18n/msg",
        "classpath:i18n/bvMsg",
        "classpath:i18n/commonMsg",
    };
    source.setBasenames(baseNameArray);
    source.setDefaultEncoding(StandardCharsets.UTF_8.name());
    return source;
}