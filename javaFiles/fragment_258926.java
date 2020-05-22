public class UploadService extends Service {

 public int counter = 0;

    public UploadService(Context applicationContext) {
        super();

        Log.i("SERVICE", "hService started");
    }

    public UploadService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        //instantiate your variables here

        //i call my startUpload method here to doing the task assigned to it

        startUpload();

        return START_STICKY;
    }



    public void startUpload() {

    //call the method with your logic here

    //mine is a sample to print a log after every x seconds

        initializeTimerTask();

    }

    /**
     * it sets the timer to print the counter every x seconds
     */
    public void initializeTimerTask() {
        // timerTask = new TimerTask() {

        //we can print it on the logs as below
        Log.i("in timer", "in timer ++++  " + (counter++));

        //or use the print statement as below
        System.out.println("Timer print " + counter++);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


      @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }

}