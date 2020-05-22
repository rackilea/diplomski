// Decode base64
byte[] array = Base64.decode(src);
// Get only encrypted data (removing first 16 byte, namely the IV)
byte[] encrypted = Arrays.copyOfRange(array, 16, array.length);
// Decrypt data
decrypted = new String(cipher.doFinal(encrypted));