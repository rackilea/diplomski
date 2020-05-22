char[] password = {'c','h','a','n','g','e','i','t'};
byte[] data = "Hello World!".getBytes();

// Encrypt!
byte[] encrypted = OpenSSL.encrypt("des3", password, data);
System.out.println("ENCRYPTED: [" + new String(encrypted) + "]");

// Decrypt results of previous!
data = OpenSSL.decrypt("des3", password, encrypted);
System.out.println("DECRYPTED: [" + new String(data) + "]");


OUTPUT:
=======================
ENCRYPTED: [U2FsdGVkX19qplb9qVDVVEYxH8wjJDGpMS+F4/2pS2c=]
DECRYPTED: [Hello World!]