@Bean
@Qualifier("one")
public ModelMongoRepository modelMongoRepositoryOne() throws DataAccessException, Exception {
    MongoRepositoryFactoryBean<ModelMongoRepository, Model, String> myFactory = new MongoRepositoryFactoryBean<ModelMongoRepository, Model, String>();
    MongoOperations mongoOperations = createMongoOperations("hostname1", 21979, "dbName1", "usdername1", "password1");
    myFactory.setCustomImplementation(new ModelMongoRepositoryImpl(mongoOperations));
    myFactory.setRepositoryInterface(ModelMongoRepository.class);
    myFactory.setMongoOperations(mongoOperations);

    myFactory.afterPropertiesSet();
    return myFactory.getObject();
}