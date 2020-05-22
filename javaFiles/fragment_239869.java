public String getLocalIpAddress() {
    try {
        for (Enumeration<NetworkInterface> en = NetworkInterface
                .getNetworkInterfaces(); en.hasMoreElements();) {
            NetworkInterface intf = en.nextElement();
            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                InetAddress inetAddress = enumIpAddr.nextElement();
                if (!inetAddress.isLoopbackAddress()) {
                    return inetAddress.getHostAddress().toString();
                }
            }
        }
    } catch (SocketException ex) {}
    return null;
}

public static String getBroadcast() throws SocketException {
    System.setProperty("java.net.preferIPv4Stack", "true");
    for (Enumeration<NetworkInterface> niEnum = NetworkInterface.getNetworkInterfaces(); niEnum.hasMoreElements();) {
        NetworkInterface ni = niEnum.nextElement();
        if (!ni.isLoopback()) {
            for (InterfaceAddress interfaceAddress : ni.getInterfaceAddresses()) {
                return interfaceAddress.getBroadcast().toString().substring(1);
            }
        }
    }
    return null;
}