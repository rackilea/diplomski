public static KeyPair loadKeyStore(final File keystoreFile,
        final String password, final String alias, final String keyStoreType)
        throws Exception {
    if (null == keystoreFile) {
        throw new IllegalArgumentException("Keystore url may not be null");
    }
    final KeyStore keystore = KeyStore.getInstance(keyStoreType);
    InputStream is = null;
    try {
        is = new FileInputStream(keystoreFile);
        keystore.load(is, null == password ? null : password.toCharArray());
    } finally {
        if (null != is) {
            is.close();
        }
    }
    final PrivateKey key = (PrivateKey) keystore.getKey(alias,
            password.toCharArray());
    final Certificate cert = keystore.getCertificate(alias);
    final PublicKey publicKey = cert.getPublicKey();
    return new KeyPair(publicKey, key);

}