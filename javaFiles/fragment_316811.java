@Bean
public ViewResolver htmlViewResolver() {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine(htmlTemplateResolver()));
    resolver.setContentType("text/html; charset=UTF-8");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setViewNames(new String[] {"*.html"});
    return resolver;
}

private ITemplateResolver htmlTemplateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setCharacterEncoding("UTF-8");
    resolver.setPrefix("/templates/");
    resolver.setCacheable(false);
    resolver.setTemplateMode(TemplateMode.HTML);
    return resolver;
}