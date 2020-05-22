ResteasyJacksonProvider resteasyJacksonProvider = new ResteasyJacksonProvider();
ObjectMapper mapper = new ObjectMapper();
SimpleModule myModule = new SimpleModule("myModule", new Version(1, 0, 0, null));
myModule.addSerializer(Custom.class, new CustomSerializer());
mapper.registerModule(myModule);
resteasyJacksonProvider.setMapper(mapper);
ResteasyClient client = new ResteasyClientBuilder().register(resteasyJacksonProvider).build();