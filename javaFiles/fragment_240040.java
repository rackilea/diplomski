public class MyService extends Service {

    static final public String SERVICE_RESULT = "com.my.app.MyService.SMS_UPDATED";
    static final public String SERVICE_MESSAGE = "SMS updated";

    int SECONDS = 10;

    LocalBroadcastManager broadcaster;

    ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(5);


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        ScheduledFuture scheduledFuture =
                scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {

                      // do some processing... and then

                      sendResult(SERVICE_MESSAGE);

                    }
                }, SECONDS, SECONDS, TimeUnit.SECONDS);

        return Service.START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        broadcaster = LocalBroadcastManager.getInstance(this);

       // if you need any initialization...
    }


    public void sendResult(String message) {
        Intent intent = new Intent(SERVICE_RESULT);
        if (message != null)
            intent.putExtra(SERVICE_RESULT, message);
        broadcaster.sendBroadcast(intent);
    }
}