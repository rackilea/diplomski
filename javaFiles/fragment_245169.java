URLConnection conn = new URL("http://online1.tingclass.com/lesson/shi0529/43/32.mp3").openConnection();
    InputStream is = conn.getInputStream();

    OutputStream outstream = new FileOutputStream(new File("/tmp/file.mp3"));
    byte[] buffer = new byte[4096];
    int len;
    while ((len = is.read(buffer)) > 0) {
        outstream.write(buffer, 0, len);
    }
    outstream.close();