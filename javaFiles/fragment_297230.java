try (InputStream in = conn.getInputStream();
        OutputStream out = new FileOutputStream("myimage.png")) {
    byte[] buf = new byte[4096];
    int n;
    while ((n = in.read(buf)) > 0) {
        out.write(buf, 0, n);
    }
}