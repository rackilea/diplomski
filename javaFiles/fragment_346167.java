Service service = Service.create(
        new URL("http://tomcatserver:8080/MyBeanImpl?wsdl"),
        new QName("http://superbiz.org/wsdl", "MyBeanService"));
assertNotNull(service);

MyBeanRemote myBean = service.getPort(MyBeanRemote.class);