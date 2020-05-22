ZipInputStream is;//obtained earlier

ZipEntry entry = is.getNextEntry();

while(entry != null) {
    copyStream(is, out, entry);

    entry = is.getNextEntry();
}
...

private static void copyStream(InputStream in, OutputStream out,
        ZipEntry entry) throws IOException {
    byte[] buffer = new byte[1024 * 4];
    long count = 0;
    int n = 0;
    long size = entry.getSize();
    while (-1 != (n = in.read(buffer)) && count < size) {
        out.write(buffer, 0, n);
        count += n;
    }
}