@Bean
public WebServiceTemplate webServiceTemplate(Marshaller marshaller) {
    WebServiceTemplate wsTemplate = new WebServiceTemplate(marshaller);
    wsTemplate.setInterceptors(new ClientInterceptor[]{ securityInterceptor() });
    return wsTemplate;
}