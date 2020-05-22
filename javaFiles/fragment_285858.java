String url = "localhost";
    byte addr[] = {127, 0, 0, 1};  // loopback address
    InetAddress ip1 =  InetAddress.getByName(url);
    InetAddress ip2 =  InetAddress.getByAddress(addr);
    InetAddress ip3 =  InetAddress.getLocalHost();
    // proceed with your sample code by using any of these InetAddress references