@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    super.onStartCommand(intent, flags, startId);
    String data="";
    if(intent.getExtras().containsKey("data"))
        data = intent.getStringExtra("data");
    return START_STICKY;
}