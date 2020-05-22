Client client = ClientProxy.getClient(port);
Endpoint cxfEndpoint = client.getEndpoint();
Map<String,Object> outProps = new HashMap<String,Object>();
outProps.put("action", "UsernameToken");
outProps.put("user", "login");
outProps.put("passwordType","PasswordText");
ClientPasswordCallback c = new ClientPasswordCallback();
outProps.put("passwordCallbackRef",c);

WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
cxfEndpoint.getOutInterceptors().add(wssOut);