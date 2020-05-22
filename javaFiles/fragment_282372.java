@Module
public class TestDataModule extends DataModule {

    public TestDataModule(Application application) {
        super(application);
    }

    @Override
    public DatabaseManager provideDatabaseManager(DatabaseUtil databaseUtil) {
        return mock(DatabaseManager.class);
    }
}