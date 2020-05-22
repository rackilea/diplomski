InetAddress theOneAddress = null;
Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
for (NetworkInterface netint : Collections.list(nets)) {
    if (!netint.isLoopback()) {
        theOneAddress = Collections.list(netint.getInetAddresses()).stream().findFirst().orElse(null);
        if (theOneAddress != null) {
            break;
        }
    }
}