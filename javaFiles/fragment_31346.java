HelloService service = new HelloService (
  this.getClass().getResource("originalHello.wsdl"),
  new QName("http://example.org/hello", "HelloService "));
HelloPort proxy = service.getHelloPort();

Map<String, Object> ctxt = ((BindingProvider)proxy ).getRequestContext();
ctxt.put(JAXWSProperties.HTTP_CLIENT_STREAMING_CHUNK_SIZE, 8192);
ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://new/endpointaddress");

proxy.sayHello("Hello World!");