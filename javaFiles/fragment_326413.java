@Bean
public ServletContextTemplateResolver templateResolver() {
    ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".html");
    //NB, selecting HTML5 as the template mode.
    resolver.setTemplateMode("HTML5");
    resolver.setCacheable(false);
    return resolver;
}