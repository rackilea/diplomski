String plainText = "This is a plain text which needs to be encrypted!";
String aad = "These are additional authenticated data (optional)";

AeadConfig.register();

KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);
Aead aead = AeadFactory.getPrimitive(keysetHandle);

// Encryption
byte[] ciphertext = aead.encrypt(plainText.getBytes(), aad.getBytes());

// Decryption
byte[] decrypted = aead.decrypt(ciphertext, aad.getBytes());