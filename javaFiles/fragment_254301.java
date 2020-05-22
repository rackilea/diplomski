public int[] getFreePorts(int portNumber) throws IOException {
    int[] result = new int[portNumber];
    List<ServerSocket> servers = new ArrayList<ServerSocket>(portNumber);
    ServerSocket tempServer = null;

    for (int i=0; i<portNumber; i++) {
        try {
            tempServer = new ServerSocket(0);
            servers.add(tempServer);
            result[i] = tempServer.getLocalPort();
        } finally {
            for (ServerSocket server : servers) {
                try {
                    server.close();
                } catch (IOException e) {
                    // Continue closing servers.
                }
            }
        }
    }
    return result;
}