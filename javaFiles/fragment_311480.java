// Consider having both the same, for compatibility with Windows/MacOSX/OpenSSL/etc:
String ksPassphrase = "myKSpass";
String pkPassphrase = "myPKpass";

SSLContext context = SSLContext.getInstance("TLS");
KeyManagerFactory keyMngFactory = KeyManagerFactory.getInstance("SunX509");
KeyStore keyStore = KeyStore.getInstance("PKCS12");

keyStore.load(new FileInputStream("myFile.p12"), 
ksPassphrase.toCharArray());
keyMngFactory.init(keyStore, pkPassphrase.toCharArray());
context.init(keyMngFactory.getKeyManagers(), null, null);

SSLSocketFactory sslScktFactory = context.getSocketFactory();