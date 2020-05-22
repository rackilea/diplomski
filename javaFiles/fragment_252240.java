String plainText = "This is a plain text which needs to be encrypted!";
String aad = "These are additional authenticated data (optional)";
String key = "ThisIsThe32ByteKeyForEncryption!"; // 256 bit

// Encryption
AesGcmJce agjEncryption = new AesGcmJce(key.getBytes());
byte[] encrypted = agjEncryption.encrypt(plainText.getBytes(), aad.getBytes());

// Decryption
AesGcmJce agjDecryption = new AesGcmJce(key.getBytes());
byte[] decrypted = agjDecryption.decrypt(encrypted, aad.getBytes());