public static void main(String[] args) throws InterruptedException, IOException
{
    List<String> allIps = new ArrayList<String>();
    Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
    while (e.hasMoreElements())
    {
        NetworkInterface n = e.nextElement();
        System.out.println(n.getName());
        Enumeration<InetAddress> ee = n.getInetAddresses();
        while (ee.hasMoreElements())
        {
            InetAddress i = ee.nextElement();
            System.out.println(i.getHostAddress());
            allIps.add(i.getHostAddress());
        }
    }
}