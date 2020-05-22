public KeyStore load(InputStream input, String storepass, String provider, 
String type) 
throws CredentialException {

KeyStore ks = null;

SunPKCS11 akisProvider = new SunPKCS11("pkcs.properties");
Security.addProvider(akisProvider);

try {
    if (provider == null || provider.length() == 0) {
        ks = KeyStore.getInstance(type);
    } else {
        //ks = KeyStore.getInstance(type, provider);
        ks = KeyStore.getInstance("PKCS11",akisProvider);
    }