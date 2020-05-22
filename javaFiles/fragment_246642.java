static void convertPasswordAlgorithm(String keystorePath, String fromAlgorithm, String toAlgorithm) throws Exceptionc {
    FileInputStream fileInStream = null;
    String keystoreFullPath = keystorePath + ISiteConstants.c_FILE_SEPERATOR + KEYSTORE_FILE_NAME;
    KeyStore keyStore;

    try {
        String alias = getCertificateAlias();
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        fileInStream = new FileInputStream(keystoreFullPath);

        // Try to load the keystore with fromAlgorithm password hash.
        char[] machineOldAlgPassword = getMachinePassword(fromAlgorithm).toCharArray();
        keyStore.load(fileInStream, machineOldAlgPassword);

        // Save the entry to update
        KeyStore.Entry entry = keyStore.getEntry(alias, new KeyStore.PasswordProtection(machineOldAlgPassword));
        HandleFiles.close(fileInStream);

        // If succeeded, recalculate password using toAlgorithm hash and save.
        String machineNewAlgPassword = getMachinePassword(toAlgorithm);
        keyStore.setEntry(alias, entry, new KeyStore.PasswordProtection(machineNewAlgPassword.toCharArray()));

        FileOutputStream fileOutputStream = new FileOutputStream(keystoreFullPath);
        keyStore.store(fileOutputStream, machineNewAlgPassword.toCharArray());
        HandleFiles.close(fileOutputStream);
    } finally {
        HandleFiles.close(fileInStream);
    }
}