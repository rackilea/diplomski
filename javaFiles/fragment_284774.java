...
//byte[] aesKeyb byte-array with random 32-bytes key
//byte[] iv      byte-array with random 16-bytes iv
byte[] key_iv = new byte[aesKeyb.length + iv.length];
System.arraycopy(aesKeyb, 0, key_iv, 0, aesKeyb.length);
System.arraycopy(iv, 0, key_iv, aesKeyb.length, iv.length);
...
byte[] RSAEncrypted = RSACipher.doFinal(key_iv);
FileOutputStream out = new FileOutputStream("000000.00000.TA.840_Key");
out.write(RSAEncrypted);
out.close();
...