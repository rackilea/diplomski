@Bean
    public CustomMessageSource messageSource() {
        CustomReloadableResourceBundleMessageSource messageSource = new CustomReloadableResourceBundleMessageSource();
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setBasename("messages");
        return messageSource;
    }


    public class CustomReloadableResourceBundleMessageSource extends
    ResourceBundleMessageSource implements CustomMessageSource {
    public String getMessage(String code, List<Locale> locales) {
        return locales.stream().map(locale -> getMessage(code, null, locale))
            .filter(StringUtils::isNotEmpty).findFirst()
            .orElse(getMessage(code, null, Locale.ENGLISH));
    }
}