void encrypt(InputStream source, OutputStream target, byte[] password) throws IOException {
    PdfReader reader = new PdfReader(source);
    PdfWriter writer = new PdfWriter(target, new WriterProperties().setStandardEncryption(null, password,
            EncryptionConstants.ALLOW_PRINTING, EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA));
    new PdfDocument(reader, writer).close();
}