public class MyApp extends Application {
    private static MyDb db;

    @Override
    public void onCreate() {
        super.onCreate();
        if (db == null) {
            /* use application context here */
            db = new MyDb(this.getApplicationContext());
        }
    }

    public MyDb getDb() {
        return db;
    }
}