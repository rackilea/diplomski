public static String getBase64FromFile(String path) throws IOException {
    RandomAccessFile file = new RandomAccessFile(path, "r");
    String result = "";
    int b = file.read();
    while (b != -1) {
        result = result + (char) b;
        b = file.read();
    }
    file.close();

    return result;
}