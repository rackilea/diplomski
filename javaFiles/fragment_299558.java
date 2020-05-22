MyPort port = service.getHTTPPort();
Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();

// URL
requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.remoteservice.com/service");

// Timeouts
requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 30000);

// Authentication
requestContext.put(BindingProvider.USERNAME_PROPERTY, "user");
requestContext.put(BindingProvider.PASSWORD_PROPERTY, "password");