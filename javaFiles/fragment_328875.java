@Bean
public JettyCustomizer jettyCustomizer(EmbeddedWebApplicationContext context) {
    return new JettyCustomizer(
            (JettyEmbeddedServletContainer) context.getEmbeddedServletContainer());
}

static class JettyCustomizer implements ApplicationListener<ApplicationReadyEvent> {

    private final JettyEmbeddedServletContainer container;

    JettyCustomizer(JettyEmbeddedServletContainer container) {
        this.container = container;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Server server = this.container.getServer();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8081);
        server.addConnector(connector);
        try {
            connector.start();
        }
        catch (Exception ex) {
            throw new IllegalStateException("Failed to start connector", ex);
        }
    }
}