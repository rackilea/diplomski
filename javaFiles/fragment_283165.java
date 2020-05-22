public static String getIPAddress() {
    try {
        List<NetworkInterface> interfaces = Collections.list(
                NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface networkInterface : interfaces) {
            List<InetAddress> addresses = Collections.list(
                    networkInterface.getInetAddresses());
            for (InetAddress inetAddress : addresses) {
                if (!inetAddress.isLoopbackAddress()) {
                    String sAddress = inetAddress.getHostAddress().toUpperCase();
                    if (InetAddressUtils.isIPv4Address(sAddress)) {
                        return sAddress;
                    } else {
                        int delim = sAddress.indexOf('%');
                        return delim < 0 ? sAddress : sAddress.substring(0,
                                delim);
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "";
}