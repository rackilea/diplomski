Component = new Component();
// create server
Server server = component.getServers().add(Protocol.HTTPS, 443); 
// get server parameters
Series<Parameter> parameters = server.getContext().getParameters();
// set parameters
parameters.add("keystorePath", "cert\\testServer.jks");
parameters.add("keystorePassword", "password");
parameters.add("keyPassword", "password");
parameters.add("keystoreType", "JKS");