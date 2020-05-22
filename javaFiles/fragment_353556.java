@Bean(name = "mongoDbFactory")
public MongoDbFactory mongoDbFactory()throws Exception
{
    return new MongoFactory();
}

@Bean
public MongoTemplate mongoTemplate(@Qualifier("mongoDbFactory") MongoDbFactory dbFactory) throws Exception
{
    return new MongoTemplate(dbFactory);
}