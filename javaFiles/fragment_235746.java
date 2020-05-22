public class App extends Application {

    private static App mInstance;
    private Client mClient;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // magic and stuff
        // put anything here and in anywhere in your app, activity
        // fragment, service, whatever you want
        // do App.getInstance().whatever()
        // like App.getInstance().getClient()

        mClient = new Client();
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    public static Client getClient() {
        return mClient;
    }

}