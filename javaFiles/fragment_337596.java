public String decrypt(String text) throws DecryptionException{
    try{

        c.init(Cipher.DECRYPT_MODE, key);
        byte[] textByte = Base64.decode(text, Base64.DEFAULT);

        byte[] tmp = c.doFinal(textByte);

        return new String(tmp, "UTF-8");

    }catch(IllegalBlockSizeException e){
        Log.d("Exception", "IllegalBlockSizeException");
        throw new DecryptionException();

    }  // wrote DecryptionException myself. 
       // also there is more Exceptions below
}