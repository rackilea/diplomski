public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dbmView = (TextView) findViewById(R.id.textView_dBm);
  }

  @Override
  protected void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter("com.example.broadcasts.DBM_UPDATE");
    registerReceiver(receiver, intentFilter);
  }

  @Override
  protected void onStop() {
    unregisterReceiver(receiver);
    super.onStop();
  }

  private TextView dbmView;

  private BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        dbmView.setText(intent.getStringExtra("dbm"));
    }
  }

}