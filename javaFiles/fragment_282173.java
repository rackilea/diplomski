@Bean
public TomcatEmbeddedServletContainerFactory tomcatFactory() {
    return new TomcatEmbeddedServletContainerFactory() {

        @Override
        protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
                Tomcat tomcat) {
            tomcat.enableNaming();
            return super.getTomcatEmbeddedServletContainer(tomcat);
        }

        @Override
        protected void postProcessContext(Context context) {

            ContextResource resource = new ContextResource();
            resource.setName(name);
            resource.setType(DataSource.class.getName());
            resource.setProperty("url", "...");
            resource.setProperty("username", "...");
            resource.setProperty("password", "...");
            resource.setProperty("driverClassName", "...");
            resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
            context.getNamingResources().addResource(resource);
        }
    };
}

@Bean
public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {

    JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
    bean.setJndiName("...");
    bean.setProxyInterface(DataSource.class);
    bean.setLookupOnStartup(false);
    bean.afterPropertiesSet();
    return (DataSource)bean.getObject();
}