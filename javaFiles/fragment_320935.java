@Bean
public ITemplateEngine htmlTemplateEngine() {
SpringTemplateEngine templateEngine = new SpringTemplateEngine();
ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
templateResolver.setPrefix("/");
templateResolver.setSuffix(".html");
templateResolver.setTemplateMode(TemplateMode.HTML);
templateResolver.setCacheable(false);
templateEngine.setTemplateResolver(templateResolver);
return templateEngine;
}