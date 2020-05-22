private void serveFlashPolicy() {
    ServerSocket serverSocket = null;
    Socket socket = null;
    TWBLogger.logInfo("Waiting for flash policy request on port " + FLASH_POLICY_PORT);
    try {
        serverSocket = new ServerSocket(FLASH_POLICY_PORT);
        serverSocket.setSoTimeout(ACCEPT_TIMEOUT);

        socket = serverSocket.accept();

        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        StringBuilder request = new StringBuilder();
        int c;
        while (0 < (c = reader.read())) {
            request.append((char) c);
        }

        String policyRequest = request.toString();
        if (policyRequest.startsWith(FLASH_POLICY_REQUEST)) {
            writer.print(FLASH_POLICY_RESPONSE);
            writer.print("\0");
            writer.flush();
        }
    } catch (IOException e) {
        TWBLogger.logWaring("IOException on port " + FLASH_POLICY_PORT + ": " + e.toString());
        e.printStackTrace();
    } finally {
        if (null != socket) {
            try {
                socket.close();
            } catch (Exception e) {
                // Ignore
            }
        }

        if (null != serverSocket) {
            try {
                serverSocket.close();
            } catch (Exception e) {
                // Ignore
            }
        }
    }

    TWBLogger.logInfo("Flash policy complete on port " + FLASH_POLICY_PORT);
}