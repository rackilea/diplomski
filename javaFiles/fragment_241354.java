void DownloadFromDatabase() throws MalformedURLException, IOException {

     URLConnection conn = new URL("your_url_here").openConnection();

     InputStream is = conn.getInputStream();
     OutputStream outstream = new FileOutputStream(new File("filename.txt"));

     byte[] buffer = new byte[4096];
     int len;

     while ((len = is.read(buffer)) > 0) {
      outstream.write(buffer, 0, len);
     }
     outstream.close();
     }