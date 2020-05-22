public class KillTimer extends Activity {
       @Override
       public void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.killtimer);
           WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
           int networkId = wifiManager.getConnectionInfo().getNetworkId();
           wifiManager.removeNetwork(networkId);
           wifiManager.saveConfiguration();
       }}