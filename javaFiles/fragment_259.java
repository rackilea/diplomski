@Configuration
@EnableMongoRepositories
public class MongoConfiguration {

    @Bean
    @Qualifier("one")
    public ModelMongoRepository modelMongoRepositoryOne() throws DataAccessException, Exception {
        MongoRepositoryFactoryBean<ModelMongoRepository, Model, String> myFactory = new MongoRepositoryFactoryBean<ModelMongoRepository, Model, String>();
        myFactory.setRepositoryInterface(ModelMongoRepository.class);
        myFactory.setMongoOperations(createMongoOperations("hostname1", 21979, "dbName1", "username1", "password1"));
        myFactory.afterPropertiesSet();
        return myFactory.getObject();
    }

    @Bean
    @Qualifier("two")
    public ModelMongoRepository modelMongoRepositoryTwo() throws DataAccessException, Exception {
        MongoRepositoryFactoryBean<ModelMongoRepository, Model, String> myFactory = new MongoRepositoryFactoryBean<ModelMongoRepository, Model, String>();
        myFactory.setRepositoryInterface(ModelMongoRepository.class);
        myFactory.setMongoOperations(createMongoOperations("hostname2", 21990, "dbName2", "username2", "password2"));
        myFactory.afterPropertiesSet();
        return myFactory.getObject();
    }

    private MongoOperations createMongoOperations(String hostname, int port, String dbName, String user, String pwd) throws DataAccessException, Exception {
        MongoCredential mongoCredentials = MongoCredential.createScramSha1Credential(user, dbName, pwd.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(hostname, port), Arrays.asList(mongoCredentials));
        Mongo mongo = new SimpleMongoDbFactory(mongoClient, dbName).getDb().getMongo();
        return new MongoTemplate(mongo, dbName);
    }
    //or this one if you have a connection string
    private MongoOperations createMongoOperations(String dbConnection) throws DataAccessException, Exception {
        MongoClientURI mongoClientURI = new MongoClientURI(dbConnection);
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        Mongo mongo = new SimpleMongoDbFactory(mongoClient, mongoClientURI.getDatabase()).getDb().getMongo();
        return new MongoTemplate(mongo, mongoClientURI.getDatabase());
    }
}