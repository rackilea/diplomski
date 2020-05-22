static String toHex(File file) throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream(file));

    int value = 0;
    StringBuilder hex = new StringBuilder();

    while ((value = inputStream.read()) != -1) {
        hex.append(String.format("%02X ", value));


    }
    return hex.toString();
}