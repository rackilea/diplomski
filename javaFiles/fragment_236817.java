private void initServer() {
    try (ServerSocket server = new ServerSocket(5555)) {
        while (true) {
            Socket fromclient = server.accept();

        ... // remaining code

            fromclient.close();
        }
    } catch (IOException ioe) {
        // handle failures
    }
}