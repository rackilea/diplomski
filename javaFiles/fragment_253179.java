public class SO11096275 {
    public static byte[] readImage(URL url) throws IOException {
        final ByteArrayOutputStream bais = new ByteArrayOutputStream();
        final InputStream is = url.openStream();
        try {
            int n;
            byte[] b = new byte[4096];
            while ((n = is.read(b)) > 0) {
                bais.write(b, 0, n);
            }
            return bais.toByteArray();
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://upload.wikimedia.org/wikipedia/en/b/bc/Wiki.png");
        byte[] imgData = readImage(url);
        String imgBase64 = new BASE64Encoder().encode(imgData);
        System.out.println(imgBase64);
        byte[] decodedData = new BASE64Decoder().decodeBuffer(imgBase64);
        FileUtils.writeByteArrayToFile(new File("/path/to/wikipedia-logo.png"), decodedData); // apache commons
    }
}