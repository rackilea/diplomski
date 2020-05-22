...
// TODO: not the best place to keep the app ID; change later
private static final String API_APP_ID = "Your_App_ID"; 
private FacebookApi facebookApi;
...

// and instantiate in a method (or constructor)
    private void setupFbApiInst() {
        facebookApi = new FacebookApi(API_APP_ID);
    }