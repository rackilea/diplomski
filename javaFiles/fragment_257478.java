private int              port;
private int              retryCount;
private long             startTime;
private String           hostName;
private DataInputStream  input;
private DataOutputStream output;
private Socket           socket;

public SocketClient(int port, String hostname) throws IOException {
    this.port     = port;
    this.hostName = hostname;
    establishConnection();
}


public void shutdown() {
    try {
        shutdown = true;
        input.close();
        output.close();
        socket.close();