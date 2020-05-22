WifiManager wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
try {
    InetAddress inetAddress = InetAddress.getByAddress(extractBytes(dhcpInfo.ipAddress));
    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
    for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
        //short netPrefix = address.getNetworkPrefixLength();
        Log.d(TAG, address.toString());
    }
} catch (IOException e) {
    Log.e(TAG, e.getMessage());
}