public class Monitor extends Service implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = "Monitor";

    int mActivitiesCount = 1; // At the moment when service started, the main Activity is already opened

    public Monitor() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getApplication().registerActivityLifecycleCallbacks(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        getApplication().unregisterActivityLifecycleCallbacks(this);
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        mActivitiesCount++;
        Log.d(TAG, "onActivityCreated: count: " + mActivitiesCount);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        mActivitiesCount--;
        Log.d(TAG, "onActivityDestroyed: count: " + mActivitiesCount);
        if (mActivitiesCount == 0) {
            Log.d(TAG, "All activities was destroyed");
            // do something
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}