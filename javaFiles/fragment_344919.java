public void connect() {
    try {
        connectWithRetries();
    } catch (InterruptedException e) {
        // Continue execution
    }
}

private void connectWithRetries() throws InterruptedException {
    while (!tryConnect()) {
        sleep();
    }
}

private boolean tryConnect() {
    try {
        URL url = new URL("my.remoteserver.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
    } catch (Exception e) {
        return false;
    }
    return true;
}

private void sleep() throws InterruptedException {
    Thread.sleep(5000);
}