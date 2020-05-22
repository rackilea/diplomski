MyService wcf = new MyService(url, qName);
IMyService a = wcf.getBasicHttpBinding();

Client cxfClient = ClientProxy.getClient(a);
CdataInterceptor myInterceptor = new CdataInterceptor();
cxfClient.getInInterceptors().add(myInterceptor);
cxfClient.getOutInterceptors().add(myInterceptor);