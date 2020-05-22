List<WifiConfiguration> wifiList = wifiManager.getConfiguredNetworks();
        for( WifiConfiguration i : wifiList ) {
            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                 wifiManager.disconnect();
                 wifiManager.enableNetwork(i.networkId, true);
                wifiManager.status = WifiConfiguration.Status.ENABLED;                                         
wifiManager.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);                                           
wifiManager.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);                                           
wifiManager.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);                                            
wifiManager.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);                                           wifiManager.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);                                        wifiManager.allowedProtocols.set(WifiConfiguration.Protocol.RSN);                                          wifiManager.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
                 wifiManager.reconnect();               

                 break;
            }           
         }