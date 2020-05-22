@Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix(VIEWS);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        String[] excludedViews = new String[] {"page1/page1"};
        thymeleafViewResolver.setExcludedViewNames(excludedViews);
        return thymeleafViewResolver;
    }

    @Bean  
    public InternalResourceViewResolver jspViewResolver() {  
    InternalResourceViewResolver resolver  = new InternalResourceViewResolver(); 
    resolver.setPrefix("/WEB-INF/views/");  
    resolver.setSuffix(".jsp");  
    resolver.setViewClass(JstlView.class);  
    return resolver;

    }