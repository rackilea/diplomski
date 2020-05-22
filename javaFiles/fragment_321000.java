@Bean(name = "mapper")
public PropertiesFactoryBean mapper() {
    PropertiesFactoryBean bean = new PropertiesFactoryBean();
    bean.setLocation(new ClassPathResource("com/foo/jdbc-production.properties"));
    return bean;
}