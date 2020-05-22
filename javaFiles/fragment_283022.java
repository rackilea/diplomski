class WebServiceTemplateFactory {
    //@Autowired - all dependencies that don't change, such as WebServiceMessageFactory,  Marshaller etc.

    WebServiceTemplate createWebServiceTemplate(String user, String pwd) throws Exception {
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

            //create the HTTP client 
            RequestConfig requestConfig = RequestConfig.custom().setStaleConnectionCheckEnabled(true).build(); //can set more stuff like connection timeout etc.
            SSLContext sslContext =  SSLContexts.custom().build();
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, null, null, SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER);
            BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, pwd));
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setDefaultRequestConfig(requestConfig)
                    .setSSLSocketFactory(sslSocketFactory)
                    .setDefaultCredentialsProvider(credentialsProvider)
                    .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor()) //preventing 'org.apache.http.ProtocolException: Content-Length header already present' exception
                    .build();

            //create the message sender
            HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender(httpClient);
            messageSender.afterPropertiesSet(); // just for consistency - not expecting much from this call

            webServiceTemplate.setMessageSender(messageSender);
            //... set the rest of dependencies, if needed
            return webServiceTemplate;
    }
}