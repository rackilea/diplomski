public String cipher(Key key, String alg, byte[] msg){
    try {
        Cipher c = Cipher.getInstance(alg);
        c.init(Cipher.ENCRYPT_MODE, key);
        return encoder.encodeToString(c.doFinal(msg));
    } catch (IllegalBlockSizeException e) {
        (...)
    }
}