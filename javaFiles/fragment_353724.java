@Configuration
class AppConfig {
    private int serverPort = 8081;

    @Autowired
    private ManagementServerProperties managementServerProperties;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(serverPort);

        if (managementServerProperties != null)
            managementServerProperties.setPort(8089);

        return factory;
    }
}