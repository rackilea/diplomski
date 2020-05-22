private void readCache(String filename) {
    FileInputStream inputStream;
    try {
        inputStream = openFileInput(filename);
        String body = inputStreamToString(inputStream);
        inputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String inputStreamToString(InputStream inputStream) throws Exception {
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    while ((length = inputStream.read(buffer)) != -1) {
        result.write(buffer, 0, length);
    }
    return result.toString("UTF-8");
}