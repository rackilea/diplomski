@Configuration
public class WebMVCConfig implements WebMvcConfigurer, ApplicationContextAware {
    private static final String CHARACTER_ENCODING = "UTF-8";
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ViewResolver htmlViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding(CHARACTER_ENCODING);
        resolver.setViewNames(new String[] { "*.html" });
        return resolver;
    }

    @Bean
    public ViewResolver javascriptViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setContentType("application/javascript");
        resolver.setCharacterEncoding(CHARACTER_ENCODING);
        resolver.setViewNames(new String[] { "*.js" });
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setMessageSource(messageSource());
        engine.addTemplateResolver(htmlTemplateResolver());
        engine.addTemplateResolver(javascriptTemplateResolver());
        return engine;
    }

    private ITemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setOrder(0);
        resolver.setCheckExistence(true);
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:templates/");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setSuffix(".html");
        return resolver;
    }

    public ITemplateResolver javascriptTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setOrder(1);
        resolver.setCheckExistence(true);
        resolver.setPrefix("classpath:/static/js/");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
        msgSource.setAlwaysUseMessageFormat(false);
        msgSource.setBasename("messages");
        msgSource.setDefaultEncoding(CHARACTER_ENCODING);
        msgSource.setFallbackToSystemLocale(true);
        msgSource.setUseCodeAsDefaultMessage(false);
        return msgSource;
    }
}