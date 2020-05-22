WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
Method[] wmMethods = wifi.getClass().getDeclaredMethods();
for(Method method: wmMethods){
  if(method.getName().equals("setWifiApEnabled")){
    WifiConfiguration netConfig = new WifiConfiguration();
    netConfig.SSID = "\"PROVAAP\"";
    netConfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
    netConfig.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
    netConfig.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
    netConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);    netConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
    netConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
    netConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
    netConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);  

    try {
      method.invoke(wifi, netConfig,true);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}