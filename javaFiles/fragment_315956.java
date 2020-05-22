URLConnection connection = url.openConnection();
InputStream is = null;
try {
    is = connection.getInputStream();
} catch (IOException ioe) {
    if (connection instanceof HttpURLConnection) {
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        int statusCode = httpConn.getResponseCode();
        if (statusCode != 200) {
            is = httpConn.getErrorStream();
        }
    }
}