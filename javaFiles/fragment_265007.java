private static void signFile(String fileName, InputStream keyIn, OutputStream out, char[] pass, boolean armor)
        throws GeneralSecurityException, IOException, PGPException {
    if (armor) {
        out = new ArmoredOutputStream(out);
    }

    PGPSecretKey pgpSec = readSecretKey(keyIn);
    PGPPrivateKey pgpPrivKey = pgpSec
            .extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(pass));
    PGPSignatureGenerator sGen = new PGPSignatureGenerator(
            new JcaPGPContentSignerBuilder(pgpSec.getPublicKey().getAlgorithm(), PGPUtil.SHA1).setProvider("BC"));

    sGen.init(PGPSignature.BINARY_DOCUMENT, pgpPrivKey);

    BCPGOutputStream bOut = new BCPGOutputStream(out);

    InputStream fIn = new BufferedInputStream(new FileInputStream(fileName));

    byte[] buf = new byte[1024];
    int len;
    while ((len = fIn.read(buf)) > 0) {
        sGen.update(buf, 0, len);
    }

    //int ch;
    //while ((ch = fIn.read()) >= 0) {
    //  sGen.update((byte) ch);
    //}

    fIn.close();

    sGen.generate().encode(bOut);

    if (armor) {
        out.close();
    }

    out.close();
    bOut.close();
}