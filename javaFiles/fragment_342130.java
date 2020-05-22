@Bean
public TomcatServletWebServerFactory tomcatFactory() {
    return new TomcatServletWebServerFactory() {

        @Override
        protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
            tomcat.getServer().addLifecycleListener(modCluster());
            return new TomcatWebServer(tomcat);
        }

    };
}