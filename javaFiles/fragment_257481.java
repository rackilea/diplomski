} catch(IOException e) {
            logger.error("unable to close reader");
        }
    }
}

private void establishConnection() {
        retryCount = 1;
        startTime  = System.currentTimeMillis();

        while (!shutdown) {
            try {
                if(!isConnected) {
                    socket = new Socket(hostName,port);
                    socket.setKeepAlive(true);
                    input       = new DataInputStream(socket.getInputStream());
                    output      = new DataOutputStream(socket.getOutputStream());
                    isConnected = true;
                    shutdown    = true;