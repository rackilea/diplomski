mWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);

    if(!mWifiManager.isWifiEnabled())
        mWifiManager.setWifiEnabled(true);
    mWifiManager.startScan();

    wifiReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context c, Intent intent)
        {
            if(mWifiManager != null) {
                List<ScanResult> networks = mWifiManager.getScanResults();
                showWifi(networks);
            }
        }
    };

    registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));