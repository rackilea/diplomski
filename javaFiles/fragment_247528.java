public static byte[] readFile(File file) throws IOException {
    FileInputStream in = new FileInputStream(file);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    int ch = -1;
    while ((ch = in.read()) != -1)
        bos.write(ch);
    return bos.toByteArray();
}