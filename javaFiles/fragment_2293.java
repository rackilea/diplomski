{   // WAY 4
    QName qname = new QName("urn:playground:jax-ws", "MyService");
    MyService service = new MyService(null, qname);
    IHello port = service.getHelloPort();
    BindingProvider bindingProvider = (BindingProvider) port;
    bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceURL);
    System.out.println(port.sayHello("John Silver"));
}