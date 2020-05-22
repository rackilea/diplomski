byte[] encrypted = null;

try (   InputStream resourceStream = ...;
        OutputStream encryptedResult = new ByteArrayOutputStream()  ) {
    encrypt(resourceStream, encryptedResult, password);
    encrypted = encryptedResult.toByteArray();
}

try (   InputStream encryptedSource = new ByteArrayInputStream(encrypted);
        OutputStream signedResult = response.getOutputStream()   ) {
    sign(encryptedSource, signedResult, "Signature", CryptoStandard.CADES, 0, false, password);
}