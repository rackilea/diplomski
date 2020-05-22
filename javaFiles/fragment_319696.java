public JarVerifier(byte rawBytes[]) {
        manifestRawBytes = rawBytes;
        sigFileSigners = new Hashtable<>();
        verifiedSigners = new Hashtable<>();
        sigFileData = new Hashtable<>(11);
        pendingBlocks = new ArrayList<>();
        baos = new ByteArrayOutputStream();
        manifestDigests = new ArrayList<>();
    }