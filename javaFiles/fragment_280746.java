@Bean
public MongoFactoryBean mongo() {
    MongoFactoryBean mongo = new MongoFactoryBean();
    mongo.setExceptionTranslator(new DetailedDuplicateKeyExceptionTransaltor());
    mongo.setHost("localhost");
    return mongo;
}