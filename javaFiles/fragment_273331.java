public class LocalBinder<T> extends Binder {

    private WeakReference<T> mService;

    public LocalBinder(T service) {
        mService = new WeakReference<T>(service);
    }

    public T getService() {
        return mService.get();
    }

}

public class MyService extends Service {

    private final LocalBinder<MyService> binder;

    public MyService() {
        binder = new LocalBinder<MyService>(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}

public class MyActivity extends Activity implements ServiceConnection {

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MyService.class), this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MyService serv = ((LocalBinder<MyService>) service).getService();
        // serv is your service instance now
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
    }
}