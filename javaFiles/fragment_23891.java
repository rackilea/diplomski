QName qname = new QName("http://thenamespace", "FooService");
FooService service = new FooService(null, qname); // null for ignore WSDL
Foo port = service.getFooPort();
BindingProvider bindingProvider = (BindingProvider) port;
bindingProvider.getRequestContext()
    .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
    "http://foo.com/soap/fooBean");

// Use the service
Object obj = port.doSomething(param);