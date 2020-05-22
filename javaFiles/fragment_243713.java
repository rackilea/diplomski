@RequestMapping...
public void getFile(HttpResponse resp) throws IOException {
  InputStream is = ... // get InputStream from your file
  resp.setContentType("text/html"); // or whatever is appropriate for your file
  OutputStream os = resp.getOutputStream();
  // now read from one stream and write to the other
  byte[] buffer = new byte[1024];
  int len = in.read(buffer);
  while (len != -1) {
    out.write(buffer, 0, len);
    len = in.read(buffer);
  }
}