while(true) {
    Socket socket = new Socket(ipAddress, serverPort);
    try {
        while(true) {
           // read/write operations
        }
    } catch (SocketException e) {
       continue; // this will return you to creation of new socket
    }
}