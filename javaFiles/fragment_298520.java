@Bean 
public FreeMarkerConfigurer freemarkerConfig() { 
  FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); 
  freeMarkerConfigurer.setTemplateLoaderPath("file:/opt/data/project/resources/freemarker/);
  return freeMarkerConfigurer; 
}