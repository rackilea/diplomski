try {
    // Download image to the Android client
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    Resources.asByteSource(new URL(url)).copyTo(buffer);

    // Upload image to HttpServlet
    HttpPost httpPost = new HttpPost();
    httpPost.setTarget(new URL("http-servlet-upload-url"));
    httpPost.add("image", buffer.toByteArray());
    httpPost.send();
  } catch (IOException e) {
    Logcat.error(e.getMessage());
  }