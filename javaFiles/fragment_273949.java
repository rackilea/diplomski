public class ServiceSingleton {

    private String TAG = ServiceSingleton.class.getSimpleName();

    private static ServiceSingleton mInstance;

    private Context mContext;

    private boolean mBound = false;

    private SafeService mService;

    private ServiceConnection mServiceConnection = null;

    public static ServiceSingleton getInstance(Context context) {
        if (mInstance == null)
            mInstance = new ServiceSingleton(context);
        return mInstance;
    }

    private ServiceSingleton(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public boolean startNotification() {

        if (!mBound) {

            mServiceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder service) {

                    Log.i(TAG, "onServiceConnected");

                    mService = ((SafeService.LocalBinder) service).getService();

                    mService.startNotification();
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };

            Intent intent = new Intent(this, SafeService.class);
            mBound = mContext.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

            if (!mBound) {
                Log.e(TAG, "Error cant bind to service !");
            }
        } else {
            if (mService != null) {
                mService.startNotification();
            }
        }
        return mBound;
    }

    public void stopNotification() {
        if (mBound && mService != null) {
            mService.stopNotification();
        }
    }

    public boolean isNotificationStarted() {
        if (mBound && mService != null) {
            return mService.isNotificationStarted();
        }
        return false;
    }

    public void close() {
        try {
            if (mBound) {
                if (mService!=null){
                    mService.stopNotification();
                }
                mContext.unbindService(mServiceConnection);
                mBound = false;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public boolean isBound() {
        return mBound;
    }
}