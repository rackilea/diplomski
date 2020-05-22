public class MyGuiceModule extends AbstractModule {    
    @Override
    public void configure() {
       bind(DbConnection.class).toInstance(
           new DbConnection("localhost", "username", "password"));
    }
}