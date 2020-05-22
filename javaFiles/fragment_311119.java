private static byte[] signData(OutputStream target,
                               PrivateKey key, String[] data)
    throws IOException, GeneralSecurityException
{
    Signature sig = Signature.getInstance("SHA1withRSA");
    sig.initSign(key);
    DataOutputStream dOut =
        new DataOutputStream(new SignatureOutputStream(target, sig));


    for(String s : data) {
        dOut.writeUTF(s);
    }
    byte[] signature = sig.sign();
    return signature;
}


private static void verify(PublicKey key, byte[] signature,
                              byte[] data)
    throws IOException, GeneralSecurityException
{
    Signature sig = Signature.getInstance("SHA1withRSA");
    sig.initVerify(key);

    ByteArrayOutputStream collector =
        new ByteArrayOutputStream(data.length);
    OutputStream checker = new SignatureOutputStream(collector, sig);
    checker.write(data);
    if(sig.verify(signature)) {
        System.err.println("Signature okay");
    }
    else {
        System.err.println("Signature falsed!");
    }
}


/**
 * a test method.
 */
public static void main(String[] params) 
    throws IOException, GeneralSecurityException
{
    if(params.length < 1) {
        params = new String[] {"Hello", "World!"};
    }

    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    KeyPair pair = gen.generateKeyPair();


    ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();

    byte[] signature = signData(arrayStream, pair.getPrivate(), params);
    byte[] data = arrayStream.toByteArray();

    verify(pair.getPublic(), signature, data);

    // change one byte by one
    data[3]++;

    verify(pair.getPublic(), signature, data);

    data = arrayStream.toByteArray();

    verify(pair.getPublic(), signature, data);

    // change signature
    signature[4]++;

    verify(pair.getPublic(), signature, data);

}