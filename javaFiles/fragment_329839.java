public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
    super.onCreate();

    Configuration config = new Configuration.Builder(this)
    .setDatabaseName("mydb.db")
    .setDatabaseVersion(1)
    .create();
    ActiveAndroid.initialize(config);
    }
}