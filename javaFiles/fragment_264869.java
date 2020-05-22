YourServiceName_Service svcPort;

// ....

Map<String, Object> request = ((BindingProvider) svcPort).getRequestContext();
request.put(BindingProvider.USERNAME_PROPERTY, "<username>");
request.put(BindingProvider.PASSWORD_PROPERTY, "<password>");