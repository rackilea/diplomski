[...]
ServiceFinder.setIteratorProvider(new AndroidServiceIteratorProvider());
ClientConfig clientConfig = new DefaultClientConfig();
clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
clientConfig.getClasses().add(JacksonJsonProvider.class);
Client client = Client.create(clientConfig);

WebResource webResource = client.resource("http://yoursite.net:8080/NameOfService/rest/your_class/your_method");
ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,"your input");
ArrayList<Object> list = response.getEntity(new GenericType<ArrayList<Object>>() {});
[...]