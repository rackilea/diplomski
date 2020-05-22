public class MyApplication extends Application implements my.package.ActivityLifecycleCallbacks{

    @Override
    public void onCreate() {
        super.onCreate();           
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.i("Tracking Activity Stopped", activity.getLocalClassName());

    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.i("Tracking Activity Started", activity.getLocalClassName());

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.i("Tracking Activity SaveInstanceState", activity.getLocalClassName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.i("Tracking Activity Resumed", activity.getLocalClassName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.i("Tracking Activity Paused", activity.getLocalClassName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.i("Tracking Activity Destroyed", activity.getLocalClassName());
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.i("Tracking Activity Created", activity.getLocalClassName());
    }
}