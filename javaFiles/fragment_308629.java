@Override
public void onCreate() {
    super.onCreate();
    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);
    Parse.initialize(getApplicationContext(), "****", "***");//Here throws the exception
    ParseInstallation.getCurrentInstallation().saveInBackground();
}