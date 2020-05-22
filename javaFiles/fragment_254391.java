private static final int BUFFER_SIZE = 8;

public static boolean download(URL url, File f) throws IOException {
    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);

    FileOutputStream out = new FileOutputStream(f);
    BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

    // We can move the buffer declaration outside the loop
    byte[] buffer = new byte[BUFFER_SIZE];

    long dld = 0, expected = conn.getContentLengthLong(); // TODO expected will be -1 if the content length is unknown
    while (true) {
        int n = in.read(buffer);
        if (n == -1) break;
        else dld += n;
        out.write(buffer, 0, n);
    }
    out.close();
    System.out.println(dld + "B transmitted to " + f.getAbsolutePath());
    return true;
}