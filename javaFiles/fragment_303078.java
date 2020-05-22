public class YourApplicationClassName extends Application {

@Override
public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Register any ParseObject subclass. Must be done before calling Parse.initialize()
    ParseObject.registerSubclass(YourClass.class);

    Parse.initialize(this, "APPLICATION_ID", "CLIENT_KEY");    
}