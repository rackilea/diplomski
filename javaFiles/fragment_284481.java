flag = _wifiConnection.hasSSID(String ssid);

  public boolean hasSSID(String ssid) {
        for (int i = 0; i < scanResults.size(); i++) {
            if (ssid.equals(scanResults.get(i).SSID)) {
                return true;
            }
        }
        return false;
    }