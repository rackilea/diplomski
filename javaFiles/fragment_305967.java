public static boolean isIpBoundToNetworkInterface(InetAddress ip) {

    try {
        Enumeration<NetworkInterface> nets = 
            NetworkInterface.getNetworkInterfaces();

        while (nets.hasMoreElements()) {
            NetworkInterface intf = nets.nextElement();
            Enumeration<InetAddress> ips = intf.getInetAddresses();
            while (ips.hasMoreElements())
                if (ip.equals(ips.nextElement()))
                    return true;
        }
    } catch (SocketException e) {
        // ignore
    }
    return false;
}