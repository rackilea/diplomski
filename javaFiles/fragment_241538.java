@Bean
public ServletWebServerFactory servletWebServerFactory() {
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
    tomcat.addContextCustomizers(context -> {
        if(context instanceof StandardContext) {
            ((StandardContext)context).setUnloadDelay(8000);
        }
    });
    return tomcat;
}