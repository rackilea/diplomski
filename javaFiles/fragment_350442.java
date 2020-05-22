@Configuration
public class MyAppConfiguration {

    @Autowired
    private Environment env;

    // Provide a default implementation for FreeMarkerConfigurer only
    // if the user of our config doesn't define her own configurer.
    @Bean
    @ConditionalOnMissingBean(FreeMarkerConfigurer.class)
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setTemplateLoaderPath("/WEB-INF/views/");
        return result;
    }

    ...

    @Bean
    public LocaleResolverConfigurator loc() {
        String defaultLocale = env.getProperty("my.app.config.defaultlocale", "en");
        String switchLocale = env.getProperty("my.app.config.switchlocale", "/switchlocale/{loc}");

        return LocaleResolverConfigurator.trackedInCookie().withDefaultLocale(defaultLocale).withSwitchUrl(switchLocale);
    }