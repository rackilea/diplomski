URLConnection connection = url.openConnection();
InputStream is = connection.getInputStream();
if (connection instanceof HttpURLConnection) {
   HttpURLConnection httpConn = (HttpURLConnection) connection;
   int statusCode = httpConn.getResponseCode();
   if (statusCode != 200 /* or statusCode >= 200 && statusCode < 300 */) {
     is = httpConn.getErrorStream();
   }
}