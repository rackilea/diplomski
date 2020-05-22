char[] password;
String alias;
java.security.KeyStore keyStore = KeyStore.getInstance("PKCS12", "BC");
keyStore.load(inputStream, password);
java.security.PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password);
java.security.keystore.PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) keyStore.getEntry(alias, new KeyStore.PasswordProtection(password));