public static String readLine(InputStream inputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int c;
    for (c = inputStream.read(); c != '\n' && c != -1 ; c = inputStream.read()) {
        byteArrayOutputStream.write(c);
    }
    if (c == -1 && byteArrayOutputStream.size() == 0) {
        return null;
    }
    String line = byteArrayOutputStream.toString("UTF-8");
    return line;
}