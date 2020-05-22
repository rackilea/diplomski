JAXRSClientFactoryBean sf = new JAXRSClientFactoryBean();
sf.setResourceClass(serviceClass);
sf.setAddress("http://" + getServerUrl() + "/cxf/" + serviceName);
sf.setProviders(providers);

ConduitInitiatorManager cim = sf.getBus().getExtension(ConduitInitiatorManager.class);
   cim.registerConduitInitiator("http://cxf.apache.org/transports/http", 
   new HTTPTransportFactory(sf.getBus()));

service = sf.create(serviceClass);