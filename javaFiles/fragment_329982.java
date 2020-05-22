byte[] encrypt(String raw) throws IOException {
    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
         CipherOutputStream cipherStream = new CipherOutputStream(out, this.a)) {
        cipherStream.write(raw.getBytes(Charset.forName("UTF-8")));
        cipherStream.close();
        return out.toByteArray();
    }
}