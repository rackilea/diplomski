SocketAddress socketAddress = socketName.getRemoteSocketAddress();

if (socketAddress instanceof InetSocketAddress) {
    InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
    if (inetAddress instanceof Inet4Address)
        System.out.println("IPv4: " + inetAddress);
    else if (inetAddress instanceof Inet6Address)
        System.out.println("IPv6: " + inetAddress);
    else
        System.err.println("Not an IP address.");
} else {
    System.err.println("Not an internet protocol socket.");
}