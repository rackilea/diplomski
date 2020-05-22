HelloService service = new HelloService();
Hello port = service.getHelloPort();
BindingProvider bindingProvider = (BindingProvider) port;
bindingProvider.getRequestContext().put(
      BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
      "http://foo:8086/HelloWhatever");
String response = port.sayHello(name);