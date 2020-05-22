String bssid = getCurrentSsid(getContext());

if(bssid != null && bssid.equals("HOME_BSSID")) {
    serverAdress = lan + ":3001";
} else if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) {
    serverAdress = address + ":3001";
} else {
    // both networks are offline
}