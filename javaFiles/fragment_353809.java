URL url = new URL(
    "http://en.wikipedia.org/wiki/Main_Page");
HttpURLConnection httpConnection = (HttpURLConnection) url
    .openConnection();
httpConnection.setRequestMethod("HEAD");
httpConnection.connect();
long lastModified = httpConnection.getLastModified();
if (lastModified != 0) {
  System.out.println(new Date(lastModified));
} else {
  System.out.println("Last-Modified not returned");
}
httpConnection.disconnect();

// TODO: error handling