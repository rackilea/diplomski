private static IQuartzManagerRemote getPort(String endpointURI) throws MalformedURLException   {
           QName serviceName = new QName("urn:foo", "FooQuartzManagerBean");
           URL wsdlURL = new URL(endpointURI);

           Service service = Service.create(wsdlURL, serviceName);
           return service.getPort(IQuartzManagerRemote.class);
         }