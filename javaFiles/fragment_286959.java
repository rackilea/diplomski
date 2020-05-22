HttpURLConnection httpConn = (HttpURLConnection)_urlConnection;
InputStream _is;
if (httpConn.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
    _is = httpConn.getInputStream();
} else {
     /* error from server */
    _is = httpConn.getErrorStream();
}