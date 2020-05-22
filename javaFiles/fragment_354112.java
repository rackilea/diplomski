try
{
    NetworkInterface eth0 = null;
    Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();

    while (enumeration.hasMoreElements())
    {
        eth0 = enumeration.nextElement();

        if ("eth0".equalsIgnoreCase (eth0.getName()))
        {
            break;
        }
    }

    this.socket = new MulticastSocket (PORT);
    socket.setSoTimeout (60000);
    socket.joinGroup (new InetSocketAddress (MULTICAST_ADDRESS, PORT), eth0);
}
catch (Exception ex)
{
    ...