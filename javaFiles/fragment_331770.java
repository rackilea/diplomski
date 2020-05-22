public class MyApplication extends Application {

    private AwsHelper aws;
    // etc

    public void onCreate(...) {
        userPool = new CognitoUserPool(this, POOL_ID, CLIENT_ID, CLIENT_SECRET, new ClientConfiguration());
    }