ObjectFactory factory = new ObjectFactory();
TokenRequest tokenRequest = factory.createTokenRequest();
tokenRequest.setLogin(12345);
tokenRequest.setPassword(factory.createTokenRequestPassword("password"));

//create your service should be something similar to this 
ClientTradingService service = new ClientTradingService();
IClientTradingApi iservice = service.getBasicHttpBindingIClientTradingApi();

//do your request should be something similar to this 
TokenResponse tokenResponse = iservice.getAuthenticationToken(tokenRequest);

//now you can get the info from the response 
tokenResponse.getToken();//this should return the authentication token