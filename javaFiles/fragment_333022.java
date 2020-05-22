@Bean
public ServletContextTemplateResolver templateResolver() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setCacheable(false);
    templateResolver.setTemplateMode("HTML5");
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setPrefix(HTML_VIEWS);
    templateResolver.setSuffix(".html");

    return templateResolver;
}

@Bean
public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.addDialect(new SpringSecurityDialect());
    templateEngine.addDialect(new LayoutDialect(new GroupingStrategy()));
    templateEngine.setTemplateResolver(templateResolver());

    return templateEngine;
}

@Bean
public ViewResolver viewResolver() {

    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setCharacterEncoding("UTF-8");
    viewResolver.setCache(false);
    viewResolver.setOrder(1);

    return viewResolver;
}