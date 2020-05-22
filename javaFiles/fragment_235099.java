private PGPPublicKey getPGPPublicKey(String filePath) throws IOException, PGPException {
    InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
    PGPPublicKeyRingCollection pgpPublicKeyRingCollection = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new JcaKeyFingerprintCalculator());
    Iterator keyRingIterator = pgpPublicKeyRingCollection.getKeyRings();
    while (keyRingIterator.hasNext()) {
        PGPPublicKeyRing keyRing = (PGPPublicKeyRing) keyRingIterator.next();
        Iterator keyIterator = keyRing.getPublicKeys();
        while (keyIterator.hasNext()) {
            PGPPublicKey key = (PGPPublicKey) keyIterator.next();
            if (key.isEncryptionKey()) {
                return key;
            }
        }
    }
    inputStream.close();
    throw new IllegalArgumentException("Can't find encryption key in key ring.");
}

private String getUserId(String publicKeyFile) throws IOException, PGPException {
    PGPPublicKey pgpPublicKey = getPGPPublicKey(publicKeyFile);
    // You can iterate and return all the user ids if needed
    return (String) pgpPublicKey.getUserIDs().next();
}