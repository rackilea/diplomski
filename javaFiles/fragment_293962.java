wifiP2pManager.requestPeers(wifiChannel, new WifiP2pManager.PeerListListener() {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList wifiP2pDeviceList) {

            for (WifiP2pDevice device : wifiP2pDeviceList.getDeviceList())
            {
                if (device.deviceName.equals("ABC")) Log.d(tag, "found device!!! ");
                // device.deviceName
            }
        }
    });