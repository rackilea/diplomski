server.setSoTimeout(1000);
while (clients.size() > 0) {
    try {
        server.accept();
    }
    catch (SocketTimeoutException e) {
        // Ignore
    }
}