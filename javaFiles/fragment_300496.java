@Bean
public EmbeddedServletContainerCustomizer containerCustomizer() {
    return new EmbeddedServletContainerCustomizer() {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            ((JettyEmbeddedServletContainerFactory) container)
                    .addServerCustomizers(new JettyServerCustomizer() {

                @Override
                public void customize(Server server) {
                    MBeanContainer mbContainer = new MBeanContainer(
                            ManagementFactory.getPlatformMBeanServer());
                    server.addEventListener(mbContainer);
                    server.addBean(mbContainer);

                    StatisticsHandler statisticsHandler = new StatisticsHandler();
                    statisticsHandler.setHandler(server.getHandler());
                    server.setHandler(statisticsHandler);
                }
            });
        }

    };
}