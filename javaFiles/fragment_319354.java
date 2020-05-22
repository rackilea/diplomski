void connectTo(WifiP2pDevice device) {
            WifiP2pConfig wifiP2pConfig = new WifiP2pConfig();
            wifiP2pConfig.deviceAddress = device.deviceAddress;
            wifiP2pConfig.groupOwnerIntent = 0;
            wifiP2pConfig.wps.setup = WpsInfo.PBC;

            if (wifiP2pManager != null) {

                wifiP2pManager.connect(mChannel, wifiP2pConfig,
                        new ActionListener() {

                            @Override
                            public void onSuccess() {
                                // WiFiDirectBroadcastReceiver will notify us.
                                // Ignore for now.
                                Utility.showToast(
                                        WifiP2PConnectionActivity.this,
                                        Constants.CONNECTED);

                            }

                            @Override
                            public void onFailure(int reason) {
                                Utility.showToast(
                                        WifiP2PConnectionActivity.this,
                                        getErrorMessage(reason));

                            }
                        });
}