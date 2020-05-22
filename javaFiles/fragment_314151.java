try {
    InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
    socket = new Socket(serverAddr, REDIRECTED_SERVERPORT);
} catch (UnknownHostException e) {
    e.printStackTrace();
}
// next of the code