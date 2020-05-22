try {
    socket = new Socket();
    socket.connect(new InetSocketAddress("192.168.1.104", 4444), 10000);
    ...
    ...

} catch (SocketTimeoutException e) {
    System.err.println("SocketTimeoutException: " + e.getMessage());

} catch (ClassNotFoundException e) {
    System.err.println("ClassNotFoundException: " + e.getMessage());

} catch (IOException e) {
    System.err.println("IOException: " + e.getMessage());

} catch (Exception e) {
    System.err.println("Exception: " + e.getMessage());

}