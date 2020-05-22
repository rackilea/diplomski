public class MyService extends Service {
    TextView textDateTime;
    TextView textcurrentDateTime;
    DatabaseReference mDatabase;

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        Log.d("destroy", "onDestroy");
    }

    @Override
    public void onStart(Intent intent, int startid) {
        //return super.onStartCommand(intent, flags, startId);
        String currentDate = DateFormat.getDateTimeInstance().format(new Date());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        textcurrentDateTime.setText(currentDate);

        final Handler handler=new Handler();
        final Runnable updateTask=new Runnable() {
            @Override
            public void run() {
                updateCurrentTimeToFirebase();
                handler.postDelayed(this,7000);
                handler.removeCallbacks(this);
            }
        };

        handler.postDelayed(updateTask,7000);
    }
    public  void updateCurrentTimeToFirebase() {
        String currentDate = DateFormat.getDateTimeInstance().format(new Date());
        String id = mDatabase.push().getKey();
        mDatabase.child("autoUpdate").child(id).child("updateTime").setValue(currentDate);
    }
}