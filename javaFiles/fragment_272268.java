public class SampleService extends Service {

public SampleService() {
}


@Override
public IBinder onBind(Intent intent) {
    // TODO: Return the communication channel to the service.
    return null;
}

@Override
public int onStartCommand(final Intent inten, int flags, int startId) {

    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {


                        // Make use your method here..

                }
            });
        }
    }, 5000, 2000);

    return super.onStartCommand(inten, flags, startId);
}



@Override
public void onCreate() {
    super.onCreate();
}}