public class MongoFactory extends SimpleMongoDbFactory
{

    private static final String DB_PREFIX = "prefix_";

    public MongoFactory(MongoClientURI uri)
    {
        super(uri);
    }

    public MongoFactory()
    {
        super(new MongoClientURI("mongodb://localhost/test"));
    }

    @Override
    public MongoDatabase getDb(String dbName) throws DataAccessException
    {
        if(Objects.nonNull(currentTenant.get())){
            return super.getDb(DB_PREFIX+currentTenant.get());
        }
        return super.getDb();
    }
}