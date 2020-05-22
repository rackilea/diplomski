public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    connectToAP("12345", "12345");

    WifiConfiguration wifiConf = null;
    WifiManager wifiManager = (WifiManager) getSystemService(MainActivity.WIFI_SERVICE);
    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
    List<WifiConfiguration> configuredNetworks = wifiManager
    .getConfiguredNetworks();
    for (WifiConfiguration conf : configuredNetworks) {
    if (conf.networkId == 13) {
    wifiConf = conf;
    try {
    setIpAssignment("STATIC", wifiConf); // or "DHCP" for
    // dynamic setting
    setIpAddress(InetAddress.getByName("192.168.0.100"), 24,
    wifiConf);
    setGateway(InetAddress.getByName("4.4.4.4"), wifiConf);
    setDNS(InetAddress.getByName("4.4.4.4"), wifiConf);
    wifiManager.updateNetwork(wifiConf); // apply the setting
    wifiManager.saveConfiguration(); // Save it
    } catch (Exception e) {
    e.printStackTrace();
    }
    break;
    }
    }

    }

    public static void setIpAssignment(String assign, WifiConfiguration wifiConf)
    throws SecurityException, IllegalArgumentException,
    NoSuchFieldException, IllegalAccessException {
    setEnumField(wifiConf, assign, "ipAssignment");
    }

    public static void setEnumField(Object obj, String value, String name)
    throws SecurityException, NoSuchFieldException,
    IllegalArgumentException, IllegalAccessException {
    Field f = obj.getClass().getField(name);
    f.set(obj, Enum.valueOf((Class<Enum>) f.getType(), value));
    }

    public static void setIpAddress(InetAddress addr, int prefixLength,
    WifiConfiguration wifiConf) throws SecurityException,
    IllegalArgumentException, NoSuchFieldException,
    IllegalAccessException, NoSuchMethodException,
    ClassNotFoundException, InstantiationException,
    InvocationTargetException {
    Object linkProperties = getField(wifiConf, "linkProperties");
    if (linkProperties == null)
    return;
    Class laClass = Class.forName("android.net.LinkAddress");
    Constructor laConstructor = laClass.getConstructor(new Class[] {
    InetAddress.class, int.class });
    Object linkAddress = laConstructor.newInstance(addr, prefixLength);

    ArrayList mLinkAddresses = (ArrayList) getDeclaredField(linkProperties,
    "mLinkAddresses");
    mLinkAddresses.clear();
    mLinkAddresses.add(linkAddress);
    }

    public static void setGateway(InetAddress gateway,
    WifiConfiguration wifiConf) throws SecurityException,
    IllegalArgumentException, NoSuchFieldException,
    IllegalAccessException, ClassNotFoundException,
    NoSuchMethodException, InstantiationException,
    InvocationTargetException {
    Object linkProperties = getField(wifiConf, "linkProperties");
    if (linkProperties == null)
    return;
    Class routeInfoClass = Class.forName("android.net.RouteInfo");
    Constructor routeInfoConstructor = routeInfoClass
    .getConstructor(new Class[] { InetAddress.class });
    Object routeInfo = routeInfoConstructor.newInstance(gateway);

    ArrayList mRoutes = (ArrayList) getDeclaredField(linkProperties,
    "mRoutes");
    mRoutes.clear();
    mRoutes.add(routeInfo);
    }

    public static void setDNS(InetAddress dns, WifiConfiguration wifiConf)
    throws SecurityException, IllegalArgumentException,
    NoSuchFieldException, IllegalAccessException {
    Object linkProperties = getField(wifiConf, "linkProperties");
    if (linkProperties == null)
    return;

    ArrayList<InetAddress> mDnses = (ArrayList<InetAddress>) getDeclaredField(
    linkProperties, "mDnses");
    mDnses.clear(); // or add a new dns address , here I just want to
    // replace DNS1
    mDnses.add(dns);
    }

    public static Object getField(Object obj, String name)
    throws SecurityException, NoSuchFieldException,
    IllegalArgumentException, IllegalAccessException {
    Field f = obj.getClass().getField(name);
    Object out = f.get(obj);
    return out;
    }

    public static Object getDeclaredField(Object obj, String name)
    throws SecurityException, NoSuchFieldException,
    IllegalArgumentException, IllegalAccessException {
    Field f = obj.getClass().getDeclaredField(name);
    f.setAccessible(true);
    Object out = f.get(obj);
    return out;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
    return true;
    }
    return super.onOptionsItemSelected(item);
    }

    String TAG = "wifi";
    WifiManager wifiManager;

    public void connectToAP(String ssid, String passkey) {
    Log.i(TAG, "* connectToAP");
    wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
    WifiConfiguration wifiConfiguration = new WifiConfiguration();

    String networkSSID = ssid;
    String networkPass = passkey;

    Log.d(TAG, "# password " + networkPass);

    // for (ScanResult result : scanResultList) {
    // if (result.SSID.equals(networkSSID)) {
    if (true) {
    // String securityMode = getScanResultSecurity(result);
    String securityMode = "WEP";
    if (securityMode.equalsIgnoreCase("OPEN")) {

    wifiConfiguration.SSID = "\"" + networkSSID + "\"";
    wifiConfiguration.allowedKeyManagement
    .set(WifiConfiguration.KeyMgmt.NONE);
    int res = wifiManager.addNetwork(wifiConfiguration);
    Log.d(TAG, "# add Network returned " + res);

    boolean b = wifiManager.enableNetwork(res, true);
    Log.d(TAG, "# enableNetwork returned " + b);

    wifiManager.setWifiEnabled(true);

    } else if (securityMode.equalsIgnoreCase("WEP")) {

    wifiConfiguration.SSID = "\"" + networkSSID + "\"";
    wifiConfiguration.wepKeys[0] = "\"" + networkPass + "\"";
    wifiConfiguration.wepTxKeyIndex = 0;
    wifiConfiguration.allowedKeyManagement
    .set(WifiConfiguration.KeyMgmt.NONE);
    wifiConfiguration.allowedGroupCiphers
    .set(WifiConfiguration.GroupCipher.WEP40);
    int res = wifiManager.addNetwork(wifiConfiguration);
    Log.d(TAG, "### 1 ### add Network returned " + res);

    boolean b = wifiManager.enableNetwork(res, true);
    Log.d(TAG, "# enableNetwork returned " + b);

    wifiManager.setWifiEnabled(true);
    }

    wifiConfiguration.SSID = "\"" + networkSSID + "\"";
    wifiConfiguration.preSharedKey = "\"" + networkPass + "\"";
    wifiConfiguration.hiddenSSID = true;
    wifiConfiguration.status = WifiConfiguration.Status.ENABLED;
    wifiConfiguration.allowedGroupCiphers
    .set(WifiConfiguration.GroupCipher.TKIP);
    wifiConfiguration.allowedGroupCiphers
    .set(WifiConfiguration.GroupCipher.CCMP);
    wifiConfiguration.allowedKeyManagement
    .set(WifiConfiguration.KeyMgmt.WPA_PSK);
    wifiConfiguration.allowedPairwiseCiphers
    .set(WifiConfiguration.PairwiseCipher.TKIP);
    wifiConfiguration.allowedPairwiseCiphers
    .set(WifiConfiguration.PairwiseCipher.CCMP);
    wifiConfiguration.allowedProtocols
    .set(WifiConfiguration.Protocol.RSN);
    wifiConfiguration.allowedProtocols
    .set(WifiConfiguration.Protocol.WPA);

    int res = wifiManager.addNetwork(wifiConfiguration);
    Log.d(TAG, "### 2 ### add Network returned " + res);

    wifiManager.enableNetwork(res, true);

    boolean changeHappen = wifiManager.saveConfiguration();

    if (res != -1 && changeHappen) {
    Log.d(TAG, "### Change happen");

    // AppStaticVar.connectedSsidName = networkSSID;

    } else {
    Log.d(TAG, "*** Change NOT happen");
    }

    wifiManager.setWifiEnabled(true);
    }
    // }
    }

    public String getScanResultSecurity(ScanResult scanResult) {
    Log.i(TAG, "* getScanResultSecurity");

    final String cap = scanResult.capabilities;
    final String[] securityModes = { "WEP", "PSK", "EAP" };

    for (int i = securityModes.length - 1; i >= 0; i--) {
    if (cap.contains(securityModes[i])) {
    return securityModes[i];
    }
    }

    return "OPEN";
    }
}