@Autowired
private Environment env;

@Bean
public MongoFacade mongoFacade(){
    final String host = env.getProperty("database.host");
    final MongoClient mongoClient = new MongoClient(host);
    return new MongoFacade(mongoClient, "test-db");
}

@Bean
public MessageStore<Event> eventStore(ObjectMapper mapper) {
    return new MongoMessageStore<>(mongoFacade(), mapper);
}