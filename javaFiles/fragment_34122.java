URL url = new URL("https://test.com/test");
  URLConnection conn = url.openConnection();
  if(conn instanceof HttpsURLConnection) {
    ((HttpsURLConnection) conn).setSSLSocketFactory(sslSF);
  }
  conn.connect();