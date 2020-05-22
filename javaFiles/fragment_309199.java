public class SaveFCMTokenService extends Service {

    @Override
    public void onCreate() {
    // TODO Auto-generated method stub
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    // TODO Auto-generated method stub

        if(intent != null){

            Bundle b = intent.getExtras();

            if(b != null) {
                String token = b.getString("TOKEN");

                sendRegistrationToServer(token);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

     private void sendRegistrationToServer(final String token) {
          // Add custom implementation, as needed.

       DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference fcmDatabaseRef = ref.child("FCM_Device_Tokens").push();

         FCM_Device_Tokens obj = new FCM_Device_Tokens();
         obj.setToken(token);
         fcmDatabaseRef.setValue(obj);
     }
}