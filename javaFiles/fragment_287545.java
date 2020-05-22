public String encrypt(String key, String initVector, String value){
    try {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
        System.out.println("Encrypted Var is: " + android.util.Base64.encode(encrypted, android.util.Base64.DEFAULT));

        return new String(android.util.Base64.encode(encrypted, android.util.Base64.DEFAULT));

    }catch(Exception e){
      return null;
    }
}