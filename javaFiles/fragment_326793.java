@Bean
public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
        @Override
        protected void postProcessContext(Context context) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        }
    };
    tomcat.addAdditionalTomcatConnectors(createHttpConnector());
    tomcat.addContextCustomizers((TomcatContextCustomizer) context -> {
        NullRealm realm = new NullRealm();
        realm.setTransportGuaranteeRedirectStatus(301);
        context.setRealm(realm);
    });
    return tomcat;
}