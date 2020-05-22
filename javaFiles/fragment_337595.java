public String encrypt(String text) throws EncryptionException{
    try{
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] textByte = text.getBytes("UTF-8"); 
        byte[] tmp = c.doFinal(textByte);

        String return1 = Base64.encodeToString(tmp, Base64.DEFAULT);


        return return1;
}   // of course there is some exceptions catched down there