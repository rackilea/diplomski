@Configuration
public class AppConfig {

    @Value("${mongo.url}")
    private String url;

    @Value("${application.key}")
    private String secretKey;

    private MongoClient mongoClient;

    @Bean
    public MongoClient mongoClient()
    {


        String decrptedUrl = DecryptionService.decrypt(url, secretKey);


        MongoClientURI connectionString = new MongoClientURI(decrptedUrl);
        if (this.mongoClient == null) {
            this.mongoClient = new MongoClient(connectionString);
        }

        return mongoClient;
    }
    }