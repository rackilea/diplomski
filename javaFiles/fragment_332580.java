public class messaging extends FirebaseMessagingService {

   @Override
   public void onMessageReceived(RemoteMessage m) {
      store(m.getData());
      broadcastIntent();
   }

  public void broadcastIntent() {
      Intent intent = new Intent();
      intent.setAction("com.myApp.CUSTOM_EVENT");
      // We should use LocalBroadcastManager when we want INTRA app
      // communication
      LocalBroadcastManager.getInstance(YOUR_CONTEXT).sendBroadcast(intent);
  }
}