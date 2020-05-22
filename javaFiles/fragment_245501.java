WifiEnterpriseConfig enterpriseConfig = new WifiEnterpriseConfig(); 
   wifiConfig = new WifiConfiguration();
   wifiConfig.SSID = ssid; 
   wifiConfig.allowedKeyManagement.set(KeyMgmt.WPA_EAP);
   wifiConfig.allowedKeyManagement.set(KeyMgmt.IEEE8021X);
   enterpriseConfig.setIdentity(userName);
   enterpriseConfig.setPassword(passWord);
   enterpriseConfig.setEapMethod(WifiEnterpriseConfig.Eap.PEAP); 
   wifiConfig.enterpriseConfig = enterpriseConfig;