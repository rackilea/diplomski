public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "XXXXXXXXX", "XXXXXXXXX");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParsePush.subscribeInBackground("<Channel Name>");
    }
}