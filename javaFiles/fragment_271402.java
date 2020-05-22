try {
    int socketsNum = 10;
    String x = Inet4Address.getLocalHost().getHostAddress().toString();
    InetAddress addr = InetAddress.getByName(x);
    Socket[] sockets = new Socket[socketsNum];
    for (Socket s : sockets) {
        s = new Socket(webN, trgtPNo , addr , portNo);   
    }
} catch (Exception e) {
    e.printStackTrace();
}