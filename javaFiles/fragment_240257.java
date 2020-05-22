public static void main(String[] args) throws IOException {
    try (InputStream is = new BufferedInputStream(new FileInputStream(INPUT_FILE));
        OutputStream wos = new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE))) {
        int len = 0;
        byte[] brr = new byte[1000];
        while ((len = is.read(brr)) != -1) {
            wos.write(brr, 0, len);
        }
    }
}