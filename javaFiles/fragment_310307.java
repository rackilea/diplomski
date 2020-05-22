JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
sf.setResourceClasses(abc.class);

List providers = new ArrayList();
sf.setProviders(providers);
sf.setAddress(ENDPOINT_ADDRESS);

server = sf.create();