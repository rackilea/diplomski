public class MySimpleMongoDbFactory extends SimpleMongoDbFactory {

    PersistenceExceptionTranslator translator = new       
            DetailedDuplicateKeyExceptionTransaltor();

    public MySimpleMongoDbFactory(Mongo mongo, String databaseName) {
        super(mongo, databaseName);
    }

    @Override
    public PersistenceExceptionTranslator getExceptionTranslator() {
        return translator;
    }
}