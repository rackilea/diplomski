@Configuration
public class DataportalApplicationConfig extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(uri));
    }
    @Override
    protected String getDatabaseName() {
        return database;
    }    
    @Bean
    @Override
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new ContactReadConverter());
        return new MongoCustomConversions(converterList);
    }
}