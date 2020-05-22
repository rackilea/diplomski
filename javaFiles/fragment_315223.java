hc.setRequestProperty("Accept-Encoding", "gzip, deflate");
  if (hc.getResponseCode() == HttpConnection.HTTP_OK) {
      InputStream in = hc.openInputStream();
      if ("gzip".equals(hc.getEncoding())) 
         in = new GZIPInputStream(in);
  ...