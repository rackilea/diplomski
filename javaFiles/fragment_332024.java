public static void verify(byte[] sig, byte[] original) throws Exception {

    Keystore keystore = initKeystore();
    PublicKey key = keystore.getCertificate(getCertAlias()).getPublicKey();
    Signature s = Signature.getInstance("SHA256withRSA");
    s.initVerify(key);
    s.update(original);

    if ( ! s.verify(sig)) {
        System.out.println("Signature check FAILED");
        return;
    }
    System.out.println("Signature check PASSED");


}