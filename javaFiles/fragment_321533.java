@Configuration
@Profile("!local")
public class DatabaseConfiguration extends AbstractCloudConfig {
    @Bean
    public MongoDbFactory documentMongoDbFactory() {
        return connectionFactory().mongoDbFactory();
    }
}