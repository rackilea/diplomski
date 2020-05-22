@Bean
public TomcatEmbeddedServletContainerFactory containerFactory() {
    return new TomcatEmbeddedServletContainerFactory() {
        protected void customizeConnector(Connector connector) {
            super.customizeConnector(connector);
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
                (AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(value);
            }
        }
    };

}