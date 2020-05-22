public static void talk2ExternalProcess() {
    Socket socket = null;
    BufferedWriter outputWriter = null;
    try {
        socket = new Socket("localhost", 3333);
        outputWriter = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));
    } catch (UnknownHostException e) {
        log.error("Don't know about host: localhost, " + e);
    } catch (IOException e) {
        log.error("Couldn't get IO for the connection to localhost, " + e);
    }

    if (socket != null && outputWriter != null) {
        try {
            outputWriter.write("Kill yourself :D");
        } catch (UnknownHostException e) {
            log.error("Trying to connect to unkown host: " + e);
        } catch (IOException e) {
            log.error("IO Exception: " + e);
        } finally {
            try {
                outputWriter.close();
                socket.close();
            } catch (IOException ex) {
                log.error("IO Exception: " + ex);
            }
        }
    } else {
        log.warn("null socket or outputwriter");
    }
}