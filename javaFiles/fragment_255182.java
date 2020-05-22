OkHttpClient client = new OkHttpClient();
OutputStream out = null;
try {
    URL url = new URL("http://www.example.com");
    HttpURLConnection connection = client.open(url);
    for (Map.Entry<String, String> entry : multipart.getHeaders().entrySet()) {
        connection.addRequestProperty(entry.getKey(), entry.getValue());
    }
    connection.setRequestMethod("POST");
    // Write the request.
    out = connection.getOutputStream();
    multipart.writeBodyTo(out);
    out.close();

    // Read the response.
    if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new IOException("Unexpected HTTP response: "
                + connection.getResponseCode() + " " + connection.getResponseMessage());
    }
} finally {
    // Clean up.
    try {
        if (out != null) out.close();
    } catch (Exception e) {
    }
}