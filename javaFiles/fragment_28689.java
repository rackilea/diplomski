@Bean
public MongoFacade mongoFacade(MongoClient mongoClient){
    return new MongoFacade(mongoClient, "test-db");
}

@Bean
public MessageStore<Event> eventStore(ObjectMapper mapper) {
    return new MongoMessageStore<>(mongoFacade(null), mapper);
}