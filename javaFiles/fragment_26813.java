private static boolean listen2ExternalProcess() {
    ServerSocket server = null;
    Socket serverSocked = null;
    String line;
    BufferedReader inputReader = null;
    try {
        server = new ServerSocket(3333);
        serverSocked = server.accept();
        inputReader = new BufferedReader(
            new InputStreamReader(serverSocked.getInputStream()));

        while (true) {
            line = inputReader.readLine();
            log.info("Client says: " + line);
            if (line.equals("Kill yourself :D")) {
                return true;
            }
        }
    } catch (UnknownHostException e) {
        log.error("Don't know about this, " + e);
        return false;
    } catch (IOException e) {
        log.error("Couldn't get IO for the connection, " + e);
        return false;
    } finally {
        try {
            if(serverSocked != null) serverSocked.close();
            if(inputReader != null) inputReader.close();
        } catch (IOException ex) {
            log.error("Couldn't get IO for the connection, " + ex);
            return false;
        }
    }
}