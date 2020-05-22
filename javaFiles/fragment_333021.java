@Bean
public ViewResolver viewResolver() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setTemplateMode("HTML5");
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setPrefix("/WEB-INF/html/");
    templateResolver.setSuffix(".html");

    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.addDialect(new SpringSecurityDialect());
    engine.addDialect(new LayoutDialect(new GroupingStrategy()));
    engine.setTemplateResolver(templateResolver);

    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(engine);
    viewResolver.setCache(false);

    return viewResolver;
}