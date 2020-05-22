public class MainActivity extends Activity {
    private static MainActivity ins;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ins = this;     
    }

    public static MainActivity  getInstace(){
        return ins;
    }

    public void updateTheTextView(final String t) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textV1 = (TextView) findViewById(R.id.textV1);
                textV1.setText(t);
            }
        });
    }
}


public class NotifAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            MainActivity  .getInstace().updateTheTextView("String");
        } catch (Exception e) {

        }           
    }
}