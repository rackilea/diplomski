public static ECPrivateKey privateKeyParse(byte[] privateKey) throws Exception {

        InputStream pgpIn = PGPUtil.getDecoderStream(new ByteArrayInputStream(privateKey));

        PGPObjectFactory pgpFact = new PGPObjectFactory(pgpIn, new JcaKeyFingerprintCalculator());
        PGPSecretKeyRing pgpSecRing = (PGPSecretKeyRing) pgpFact.nextObject();
        PGPSecretKey pgpSec = pgpSecRing.getSecretKey();

        PGPPrivateKey pgpPriv = pgpSec.extractPrivateKey(null);

        JcaPGPKeyConverter converter = new JcaPGPKeyConverter();
        // this is the part i was missing from Peter Dettman's answer. pass BC provider to the converter
        converter.setProvider(new BouncyCastleProvider());
        PrivateKey key = converter.getPrivateKey(pgpPriv);
        return (ECPrivateKey) key;
    }