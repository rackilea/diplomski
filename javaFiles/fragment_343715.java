@Bean
public SpringTemplateEngine templateEngine(){
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setEnableSpringELCompiler(true);
    templateEngine.setTemplateResolver(templateResolver());
    templateEngine.addDialect(new MyDialect());
    return templateEngine;
}