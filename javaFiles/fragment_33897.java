public byte[] decipher(Key key, String alg, String msg){
    try {
        Cipher c = Cipher.getInstance(alg);
        c.init(Cipher.DECRYPT_MODE,key);
        return c.doFinal(decoder.decode(msg));
    } catch (IllegalBlockSizeException e) {
        (...)
    }
}