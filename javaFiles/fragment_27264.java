public void insertDevice(String randomString, String deviceId) {

    String request = "http://website.com/test";
    URL url = new URL(request);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setRequestMethod("POST");

    String urlParameters = "key=" + randomString + "&device_id=" + deviceId;
    byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

    conn.setDoOutput(true);

    try (OutputStream os = conn.getOutputStream()) {
        os.write(postData);
    }

    conn.connect();

    // Get response code, e.g. 200.
    // conn.getResponseCode();

    // Read server response data with conn.getInputStream() or conn.getErrorStream().

    conn.disconnect();
}