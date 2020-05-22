public static void checkServiceMan() {
    String address = "https://WSDL_URL";

    JaxWsProxyFactoryBean jaxWsProxy = new JaxWsProxyFactoryBean();
    jaxWsProxy.setServiceClass(DOFairservice.class);
    jaxWsProxy.setAddress(address);

    DOFairservice serviceClient = (DOFairservice) jaxWsProxy.create();

    ObjectFactory factory = new ObjectFactory();
    UserCredentials uc = factory.createUserCredentials();
    uc.setUserName("username");
    uc.setPassword("password");

    String resp = serviceClient.checkService(uc); **<--- New Argument Here**
    System.out.println("Response from Customs Web Service: "+ resp);

    System.out.println("Web Service Header Test Done");
}