public class MyActivity extends Activity {

    public void onCreate(Bundle state) {
        LocalBroadcastManager.getInstance(this).registerReceiver(new MessageHandler(),
                                                             new IntentFilter("kill"));
    }

    private void killActivity() {
        finish();
    }

    public class MessageHandler extends BroadcastReceiver {
        onReceive(Context context, Intent intent) {
            killActivity();
        }

}