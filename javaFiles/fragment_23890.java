ClassLoader classloader = Thread.currentThread().getContextClassLoader();
URL wsdlLocation = classloader.getResource("MyHelloService.wsdl");
QName serviceName= new QName("http://test.com/", "MyHelloService");

MyHelloService service = new MyHelloService(wsdlLocation, serviceName);
service.sayHello("Test");