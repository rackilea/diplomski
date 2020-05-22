class Transport {
    public static void main(String[] args){
        ResourceConfig rc = new PackagesResourceConfig(Transport.class.getPackage().getName());     
        String url = "http://myhost:8080/myURL";        
        URI uri = UriBuilder.fromUri(url).build();
        HttpServer server = GrizzlyServerFactory.createHttpServer(uri, new HttpHandler() {
            @Override
            public void service(Request request, org.glassfish.grizzly.http.server.Response response) throws Exception {
                response.setStatus(404, "Not found");
                response.getWriter().write("404: not found");   
            }
        }); 

        // Initialize and register Jersey Servlet
        WebappContext context = new WebappContext("WebappContext", "");
        ServletRegistration registration = context.addServlet("ServletContainer", ServletContainer.class);
        registration.setInitParameter(ServletContainer.RESOURCE_CONFIG_CLASS, 
            ClassNamesResourceConfig.class.getName());
        registration.setInitParameter(ClassNamesResourceConfig.PROPERTY_CLASSNAMES, Transport.class.getName());
        registration.addMapping("/*");
        context.deploy(server);


        SSLContextConfigurator sslContext = new SSLContextConfigurator();
        sslContext.setKeyStoreFile("path_to_my_keystore");
        sslContext.setKeyStorePass("password");
        sslContext.setTrustStoreFile("path_to_my_truststore");
        sslContext.setTrustStorePass("password");
        sslContext.setSecurityProtocol("TLSv1.2");
        SSLEngineConfigurator sslEngineConfigurator = new  SSLEngineConfigurator(sslContext);
        sslEngineConfigurator.setNeedClientAuth(true);
        sslEngineConfigurator.setWantClientAuth(true);
        sslEngineConfigurator.setEnabledCipherSuites(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA"});
        sslEngineConfigurator.setClientMode(false);
        NetworkListener listener = new NetworkListener("grizzly_ssl", uri.getHost(), 8443);
        listener.setSecure(true);
        listener.setSSLEngineConfig(sslEngineConfigurator);
        server.addListener(listener);
    }

    @POST
    @Produces({ MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_XML })
    @Path("foo")
    public Response receivePayload(@Context HttpServletRequest request, MyPayload payload) {
        X509Certificate[] certChain = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        if (certChain == null || certChain.length == 0){
        LOG.info("X509cert not found");
            return null;
        }
        X509Certificate certificate = certChain[0];
        // get information such as CN from certificate
    }
}