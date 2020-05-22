final WifiManager wifiManager = (WifiManager) YourActivity.this.getSystemService(Context.WIFI_SERVICE); 

            if (!wifiManager.isWifiEnabled()) {

                wifiManager.setWifiEnabled(true); //If it's, off turn it on.

            }else{

                //Do what you want to do with wi-fi.            

            }