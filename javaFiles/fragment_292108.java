ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new GeoJsonModule());
mapper.registerModule(new GeoModule());
// Our custom module
mapper.registerModule(new GeoModuleExt());

ClientConfig config = new DefaultClientConfig();
config.getSingletons().add(new JacksonJsonProvider(mapper));
Client client = Client.create(config);