@Override
public void onConnected(Bundle connectionHint) {
     if(wifiManager.isWifiEnabled()){
         sendMessageWidget();
     } else {
         showWifiSettingsAlert();
     }
}