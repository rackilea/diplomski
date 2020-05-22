@Provider
public class DBPoolInjectableProvider extends SingletonTypeInjectableProvider<Context, BoneCPDataSource> {

    public DBPoolInjectableProvider() throws SQLException {
        super(BoneCPDataSource.class, APIMain.getDBPool());
    }
}