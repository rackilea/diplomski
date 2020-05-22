@Override
public int onStartCommand(Intent intent, int flags, int startId) {

    if (intent != null) {
        long time = intent.getLongExtra("Time",0);
        // Do your ticking here, based on that variable.
    }
    //...
}