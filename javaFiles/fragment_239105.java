@Bean
public EmbeddedServletContainerCustomizer customizer() {
    return container -> {
        if (container instanceof TomcatEmbeddedServletContainerFactory) {
            TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
            tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
        }
    };
}