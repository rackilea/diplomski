@Bean
public ServletContextTemplateResolver templateResolver() {
    ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".html"); // here
    resolver.setTemplateMode("HTML5");
    resolver.setOrder(1);
    return resolver;
}