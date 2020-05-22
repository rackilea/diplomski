Client client = ClientProxy.getClient(servicePort);

HTTPConduit http = (HTTPConduit) client.getConduit();
HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

//This is the magic line. Setting this to false solved the problem
httpClientPolicy.setAllowChunking(false);

http.setClient(httpClientPolicy);