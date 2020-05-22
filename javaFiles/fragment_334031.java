@Bean
@ConditionalOnProperty(name = "isSSLEnabled", havingValue = "true")
public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
    tomcatFactory.setSsl(createSsl());
    tomcatFactory.setPort(sslConfig.getHttpsPort());
    return tomcatFactory;
}

private Ssl createSsl() {
    Ssl ssl = new Ssl();
    try {
        ssl.setKeyStore("/path/to/keystore.pkcs12");
        ssl.setKeyStorePassword(new String(Base64.getDecoder().decode(sslConfig.getKeyPassword())));
        ssl.setKeyAlias(sslConfig.getKeyAlias());
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
    return ssl;
}