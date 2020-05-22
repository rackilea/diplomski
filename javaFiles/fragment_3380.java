public String getIP(){
    String ip="no network";
    try {
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        outmost:
        for (; n.hasMoreElements();)
        {
            NetworkInterface e = n.nextElement();
            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements();)
            {
                InetAddress addr = a.nextElement();             
                if (addr instanceof Inet4Address){ // return the first IPv4 addr (127.0.1.1 is always last)
                    if (addr.isSiteLocalAddress()){
                        ip=addr.getHostAddress();
                        break outmost;
                    }

                }
            }
        }           
    } catch (UnknownHostException e1) {
    } catch (SocketException e) {
    } 
    return ip;      
}