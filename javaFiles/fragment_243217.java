public static int copy (InputStream is, OutputStream out) throws IOException {
    byte [] buff = new byte[1024];
    int len = is.read(buff);
    int total = 0;

    while (len > 0) {
        total += len;
        out.write(buff, 0, len);
        len = is.read(buff);
    }

    return total;
}