KeyStore readKeyStore() {
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

    // get user password and file input stream
    char[] password = getPassword();

    java.io.FileInputStream fis = null;
    try {
        fis = new java.io.FileInputStream("keyStoreName");
        ks.load(fis, password);
    } finally {
        if (fis != null) {
            fis.close();
        }
    }
    return ks;
}