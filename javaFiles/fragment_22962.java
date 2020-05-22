public class AsyncTaskInServiceService extends Service {

    public AsyncTaskInServiceService() {
        super("AsyncTaskInServiceService ");
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Connect to database here
                try {
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5000);
    }
}