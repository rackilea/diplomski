try (   InputStream resourceStream = ...;
        OutputStream encryptedResult = new FileOutputStream(encryptedFile)  ) {
    encrypt(resourceStream, encryptedResult, password);
}

try (   InputStream encryptedSource = new FileInputStream(encryptedFile);
        OutputStream signedResult = new FileOutputStream(signedFile)) {
    sign(encryptedSource, signedResult, "Signature", CryptoStandard.CADES, 0, false, password);
}