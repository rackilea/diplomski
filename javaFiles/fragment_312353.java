private static List<InetAddress> getIpAddress() {
  try {
    List<InetAddress> result = new ArrayList<InetAddress>();

    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    while (interfaces.hasMoreElements()) {
      NetworkInterface intf = interfaces.nextElement();
      Enumeration<InetAddress> addresses = intf.getInetAddresses();
      while (addresses.hasMoreElements()) {
        InetAddress address = addresses.nextElement();
        if (!address.isLoopbackAddress() && !address.isLinkLocalAddress()) {
          result.add(address);
        }
      }
    }
    return result;
  } catch (SocketException ex) {
    Log.e(TAG, "Failed to list network interfaces.", ex);
    return null;
  }
}