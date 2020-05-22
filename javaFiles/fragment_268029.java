@Bean
public static PropertyPlaceholderConfigurer propertyConfigurer() {
 PropertyPlaceholderConfigurer ppc= new PropertyPlaceholderConfigurer();
 ppc.setSearchSystemEnvironment(true);
 final Resource resource = new ClassPathResource("my.properties");
 ppc.setLocation(resource);
 return ppc;
}