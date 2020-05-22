public class MainActivity extends Activity {


  BluetoothAdapter btAdapter;
  Button button;
  TextView update;
  String enabled = "Bluetooth Enabled";
  String disabled = "Bluetooth disabled";
  String connect = "Connect";
  String disconnect = "Disconnect";
  BroadcastReceiver receiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btAdapter = BluetoothAdapter.getDefaultAdapter();
    setUp();
    action();
  }

  @Override
  public void onPause()
  {
    try{
      unregisterReceiver (receiver);
    }
    catch (NullPointerException e)
    {
      e.printStackTrace();
    }
    catch (IllegalStateException ie)
    {
      ie.printStackTrace();
    }
    super.onPause();
  }

  private void action() {
  button.setOnClickListener(new View.OnClickListener (){

    @Override
    public void onClick(View v) {
        if (btAdapter.isEnabled())
            btAdapter.disable();
        else
            btAdapter.enable();

    }

  });

 }

  private void setButtonText ()
  {
    if (btAdapter.isEnabled()) {       
      update.setText("Bluetooth is enabled");
      button.setText(disconnect);
    }

    else {

      update.setText("Bluetooth is disabled");
      button.setText(connect);
    }
  }
  private void setUp() {
    button = (Button) findViewById(R.id.button1);
    update = (TextView) findViewById(R.id.textView1);
    setButtonText();

    receiver = new BroadcastReceiver(){

      @Override
      public void onReceive(Context context, Intent intent) {
        setButtonText();

      }

    };

    IntentFilter filter = new IntentFilter (BluetoothAdapter.ACTION_STATE_CHANGED);
    registerReceiver (receiver, filter);

  }
}