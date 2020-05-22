public static byte[] fetchAttachmentFromThisURL(String path) {
    String urlString = "" + path;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        URL obj = new URL(urlString);
        int n;
        byte[] byteChunk = new byte[4096];
        while ((n = obj.openStream().read(byteChunk)) > 0) {
            baos.write(byteChunk, 0, n);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return baos.toByteArray();
}