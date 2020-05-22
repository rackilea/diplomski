ByteArrayOutputStream baos = new ByteArrayOutputStream();  
bm.compress(Bitmap.CompressFormat.PNG, 100, baos); // bm is the bitmap object   
byte[] b = baos.toByteArray();  

byte[] keyStart = "this is a key".getBytes();
KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(keyStart);
kgen.init(128, sr); // 192 and 256 bits may not be available
SecretKey skey = kgen.generateKey();
byte[] key = skey.getEncoded();    

// encrypt
byte[] encryptedData = encrypt(key,b);
// decrypt
byte[] decryptedData = decrypt(key,encryptedData);