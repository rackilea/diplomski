public class Main extends Activity {
  private TextView batteryTxt;
  private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
    @Override
    public void onReceive(Context ctxt, Intent intent) {
      int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
      batteryTxt.setText(String.valueOf(level) + "%");
    }
  };

  @Override
  public void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(R.layout.main);
    batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
    this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
  }
}