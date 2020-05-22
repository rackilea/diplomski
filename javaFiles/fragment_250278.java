public static void attemptShutdown(int port, String shutdownCookie) {
    try {
        URL url = new URL("http://localhost:" + port + "/shutdown?token=" + shutdownCookie);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.getResponseCode();
        logger.info("Shutting down " + url + ": " + connection.getResponseMessage());
    } catch (SocketException e) {
        logger.debug("Not running");
        // Okay - the server is not running
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}