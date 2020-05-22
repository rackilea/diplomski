@Bean
public ClassLoaderTemplateResolver yourTemplateResolver() {
    ClassLoaderTemplateResolver yourTemplateResolver = new ClassLoaderTemplateResolver();
    yourTemplateResolver.setPrefix("templates/");
   return yourTemplateResolver;
}