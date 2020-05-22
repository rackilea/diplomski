public class MyService extends Service {
  private BroadcastReceiver receiver;

  public MyService() { }

  @Override
  public void onCreate() {
    IntentFilter intentFilter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
    intentFilter.addDataScheme("package");
    receiver = new Receiver();
    registerReceiver(receiver, intentFilter);
  }

  //ensure that we unregister the receiver once it's done.
  @Override
  public void onDestroy() {
    unregisterReceiver(receiver);
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

}