ClientApplication clientApplication = new ClientApplication();
Set<Object> s = new HashSet<Object>();
s.add(new JacksonJsonProvider());
clientApplication.setSingletons(s);
ClientConfig clientConfig = new ClientConfig().applications(clientApplication);
RestClient restClient = new RestClient(clientConfig);