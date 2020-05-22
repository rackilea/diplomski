@Bean
public EmbeddedServletContainerCustomizer tomcatCustomizer() {
    return (container) -> {
        if (container instanceof TomcatEmbeddedServletContainerFactory) {
            ((TomcatEmbeddedServletContainerFactory) container)
                    .addConnectorCustomizers((connector) -> {
                connector.addUpgradeProtocol(new Http2Protocol());
            });
        }
    };
}