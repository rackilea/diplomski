public class DeviceManagerWindow extends Activity
{
    public static Context con;
    public static int rowCounter=0;
    Thread sendMulticast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_device_manager_window);
        WifiManager wifi = (WifiManager)getSystemService( Context.WIFI_SERVICE );
        if(wifi != null)
        {
            WifiManager.MulticastLock lock = wifi.createMulticastLock("WifiDevices");
            lock.acquire();
        }
        TableLayout tb = (TableLayout) findViewById(R.id.DeviceList);
        tb.removeAllViews();
        con = getApplicationContext();
    }
    public void searchDevice(View view) throws IOException, InterruptedException
    {
        try
        {
            sendMulticast = new Thread(new MultiCastThread());
            sendMulticast.start();
            sendMulticast.join();
        }
        catch(Exception e)
        {
            Log.v("Exception in Sending:",e.toString());
        }