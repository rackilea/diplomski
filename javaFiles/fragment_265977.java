public class Wifi {

    private final WifiManager wifiManager;

    public Wifi(Context context){
        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    public void scanWifi(String APName, ArrayList<Integer> accessPointMeanRSSArrayList, ArrayList<Integer> accessPointRSSFrequencyArrayList) throws Exception {

        ArrayList<Integer> tempRSSArrayList = new ArrayList<Integer>();
        boolean AP_found = false;