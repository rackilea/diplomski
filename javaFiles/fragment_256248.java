// Setting up the configuration
SSLClientAxisEngineConfig config = new SSLClientAxisEngineConfig();
config.setKeystore("path/to/your/keystore");
config.setKeystoreType("JKS");
config.setKeystorePassword("password");
config.setTruststore("path/to/your/truststore");
config.setTruststoreType("JKS");
config.setTruststorePassword("password");
// Very important: without this method invocation 
// the client won't work at all
config.initialize();

// Calling the web service
URL url = new URL("https://localhost:8443/someService");
WebServiceLocator locator = new WebServiceLocator (config);
WebServiceSoap port = locator.getWebServiceSoap(url);
WebServiceSoapStub stub = (WebServiceSoapStub) port;
stub.serviceMethod();