List<ScanResult> wifiScanList = wifi.getScanResults();
         wifis = new String[wifiScanList.size()];

         for(int i = 0; i < wifiScanList.size(); i++){
            wifis[i] = ((wifiScanList.get(i)).SSID);                

            if(wifis[i].equals("WiredSSID")) {

                 WifiConfiguration wifiConfig = new WifiConfiguration();
                 wifiConfig.SSID = String.format("\"%s\"", wifis[i]);
                 wifiConfig.preSharedKey = String.format("\"%s\"", "password");

                 WifiManager wifiManager = (WifiManager)getSystemService(WIFI_SERVICE);
                 //remember id
                 int netId = wifiManager.addNetwork(wifiConfig);
                 wifiManager.disconnect();
                 wifiManager.enableNetwork(netId, true);
                 wifiManager.reconnect();
             }
         }