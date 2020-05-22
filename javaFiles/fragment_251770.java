public class TestApplication extends Application implements ActivityLifecycleCallbacks {
    private static String mStringToSet;
    
    @Override
    public void onCreate() {
        super.onCreate();
        //App is not from background, a new instance of your app           is created 
        mStringToSet="new_instance";
        registerActivityLifecycleCallbacks(this);
    }

    public static String getStringToSet() {
        return mStringToSet;
    }

  
    @Override
    public void onActivityDestroyed(Activity activity) {
        if(activity instanceof MainActivity){
        //This is only called when the activity is destroyed not the application, so if the context is your desired activity then set the string here
            mStringToSet="refresh";
        }
    }

   //Implement other life cycle methods**