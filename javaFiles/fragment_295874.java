class InetAddress{
    public InetAddress(String address, int port, int timeoutMs){
        this.address = address;
        this.port = port;
        this.timeOutAfterMs = timeoutMs;
    }

    String address;
    int port;
    int timeOutAfterMs;
}