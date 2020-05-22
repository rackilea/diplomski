URL url = new URL("http://xyz.com/download.zip");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
IntpuStream in = connection.getInputStream();
FileOutputStream out = new FileOutputStream("download.zip");
copy(in, out, 1024);
out.close();


  public static void copy(InputStream input, OutputStream output, int bufferSize) throws IOException {
    byte[] buf = new byte[bufferSize];
    int n = input.read(buf);
    while (n >= 0) {
      output.write(buf, 0, n);
      n = input.read(buf);
    }
    output.flush();
  }