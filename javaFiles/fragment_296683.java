@PostConstruct
public void initialization(){
    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
    factory.setServiceClass(MyClass.class);
    factory.setAddress(myWsdlUrl);
    service = (MyClass) factory.create();
    Client client = ClientProxy.getClient(service);
    ServiceMyInterceptor interceptor = new ServiceMyInterceptor();
    client.getEndpoint().getOutInterceptors().add(interceptor);
}