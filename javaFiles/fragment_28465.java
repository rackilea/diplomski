KeyStore keyStore = KeyStore.getInstance("PKCS12");
File p12File = GET_CERT();
FileInputStream fis = new FileInputStream(p12File);
BufferedInputStream bis = new BufferedInputStream(fis);
keyStore.load(bis, password.toCharArray()); // password is the PKCS#12 password. If there is no password, just pass null
Enumeration<String> aliases = keyStore.aliases();
while (aliases.hasMoreElements()) {
    String alias = aliases.nextElement();
    /* Do something with the keystore entry */
}