public class MyApplication extends Application implements ActivityLifecycleCallbacks {

    private Handler mHandler; 

    @Override
    public void onCreate() {
        super.onCreate();

        mHandler = new Handler();
    } 

    ...  

    @Override   
    public void onActivityResumed(Activity activity) {
        Log.i("Activity Resumed", activity.getLocalClassName());

        // cancel scheduled download operation (if any) 
        mHandler.cancelCallbacksAndMessages(null);
    }   

    @Override   
    public void onActivityPaused(Activity activity) {
        Log.i("Activity Paused", activity.getLocalClassName());

        // schedule a download operation after 5 seconds
        mHandler.postDelayed(new Runnable() {
             @Override  
             public void run() {  
                  performDownloadOperation()
             }  
        }, 5000);  
    }   

    ... // other lifecycle callbacks

    private void performDownloadOperation() {
        // perform download operation here
    }

}