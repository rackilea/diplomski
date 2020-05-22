public class MyActivity extends Activity {
    private FinishReceiver finishReceiver;
    private static final String ACTION_FINISH = 
           "com.mypackage.MyActivity.ACTION_FINISH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        finishReceiver= new FinishReceiver();
        registerReceiver(finishReceiver, new IntentFilter(ACTION_FINISH));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(finishReceiver);
    }

    private final class FinishReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_FINISH)) 
                finish();
        }
    }
}