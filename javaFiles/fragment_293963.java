try {
    Method method = wifiP2pManager.getClass().getMethod("setDeviceName",
        WifiP2pManager.Channel.class, String.class, WifiP2pManager.ActionListener.class);

    method.invoke(wifiP2pManager, wifiChannel, "New Device Name", new WifiP2pManager.ActionListener() {
        public void onSuccess() {}

        public void onFailure(int reason) {}
    });
} catch (Exception e)   {}