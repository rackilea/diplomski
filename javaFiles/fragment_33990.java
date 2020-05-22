public class DeviceList extends AppCompatActivity {

    private final static int REQUEST_ENABLE_BT = 1;

    // Declare here 
    private ArrayAdapter<String> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        BluetoothAdapter BTAdapter = BluetoothAdapter.getDefaultAdapter();
        if (BTAdapter != null) {
            if (!BTAdapter.isEnabled()) {
                Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBT, REQUEST_ENABLE_BT);
            }
            if (BTAdapter.isDiscovering()) {
                BTAdapter.cancelDiscovery();
            }
            BTAdapter.startDiscovery();
        }

        ListView listView = (ListView) findViewById(R.id.inputELM);
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myEntries);
        listView.setAdapter(myArrayAdapter);

        // Register the BroadcastReceiver
        IntentFilter ifilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, ifilter);
    }

    ArrayList<String> myEntries = new ArrayList<>();
    // Create a BroadcastReceiver for ACTION_FOUND
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the name and address to an array adapter to show in a ListView
                String devs = device.getName() + "\n" + device.getAddress();
                myEntries.add(devs);
            }
        }
    };
}