public boolean isInternetWorking() {
    boolean success = false;
    try {
        URL url = new URL("https://google.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(10000);
        connection.connect();
        success = connection.getResponseCode() == 200;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return success;
}