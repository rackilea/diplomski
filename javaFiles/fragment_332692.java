public static List<InetAddress> getIPAddress() throws SocketException {

    List<InetAddress> ipAddresses = new ArrayList<InetAddress>();
    Enumeration e;
    e = NetworkInterface.getNetworkInterfaces();
    while (e.hasMoreElements()) {
        NetworkInterface ni = (NetworkInterface) e.nextElement();
        if (ni.isLoopback() || !ni.isUp()) continue;

        for (Enumeration e2 = ni.getInetAddresses(); e2.hasMoreElements(); ) {
            InetAddress ip = (InetAddress) e2.nextElement();
            ipAddresses.add(ip);
        }
    }
    return ipAddresses;
}