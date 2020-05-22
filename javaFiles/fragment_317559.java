public class AppController extends Application {
boolean bound = false;
private static AppController mInstance;

private LocalService mBoundService;

/**
 * The Background Service, which is started to communicate with multiple activities
 */
private ServiceConnection mConnection = new ServiceConnection() {
    public void onServiceConnected(ComponentName className, IBinder service) {
        mBoundService = ((LocalService.LocalBinder) service).getService();
        System.out.println("Connected!!!!");
        bound = true;
    }

    public void onServiceDisconnected(ComponentName className) {
        mBoundService = null;
        bound = false;
    }
};


public static synchronized AppController getInstance() {
    return mInstance;
}


/**
 * With the start of app controller, the Service starts too
 */
public void onCreate() {
    startService(new Intent(this, LocalService.class));
    doBindService();
    super.onCreate();
}
public void startService(){

}
void doBindService() {
    bindService(new Intent(this,
            LocalService.class), mConnection, Context.BIND_AUTO_CREATE);
}

public void stopService(){
    //stop service
}
public LocalService getService(){
    return mBoundService;
}
public void test(){
    System.out.println("Test");
}
}