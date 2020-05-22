public static byte[] sign(byte[] file) throws Exception {

    char password[] = "12345678".toCharArray();
    Provider userProvider = new sun.security.pkcs11.SunPKCS11("C:\\ForJava\\eToken.cfg");
    KeyStore ks = KeyStore.getInstance("PKCS11", userProvider);
    ks.load(null, password);   

    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    Security.addProvider(userProvider);

    //Working only with the first alias on the token
    String alias = (String)ks.aliases().nextElement();

    Signature signature = Signature.getInstance("SHA256withRSA"); 
    PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password);
    signature.initSign(privateKey);
    signature.update(file);

    byte[] result = signature.sign();
    //System.out.println("result coding: \n" +new BASE64Encoder().encode(result));
    return result;
}