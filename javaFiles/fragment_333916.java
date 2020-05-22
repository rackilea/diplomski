public class YourApplication extends Application {

    private static Context mContext;

    public static YourApplication instace;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        instace = this;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static YourApplication getIntance() {
        return instace;
    }
}