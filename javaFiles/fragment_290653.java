StringWriter soapMessageWriter=new StringWriter();
LoggingOutInterceptor loi=new LoggingOutInterceptor(new PrintWriter(soapMessageWriter));
loi.setPrettyLogging(true);
ClientProxy.getClient(serviceSoap).getOutInterceptors().add(loi);
LoggingInInterceptor lii=new LoggingInInterceptor(new PrintWriter(soapMessageWriter));
lii.setPrettyLogging(true);
ClientProxy.getClient(serviceSoap).getInInterceptors().add(lii);


//do your stuff

String soapContent=soapMessageWriter.getString();