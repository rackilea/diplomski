public class MainActivity extends AppCompatActivity { 
    Switch wifiSwitch;
    WifiManager wifi;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSwitch = (Switch) findViewById(R.id.switch_wifi);
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        checkNetworkStatus(); 

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override 
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wifi.setWifiEnabled(isChecked);
            } 
        }); 
    } 

    @Override 
    protected void onResume() { 
         super.onResume(); 

         checkNetworkStatus(); 
    } 

    public void checkNetworkStatus() { 
        Net net = new Net();
        wifiSwitch.setChecked(net.isWifiEnabled(MainActivity.this));
    } 
}