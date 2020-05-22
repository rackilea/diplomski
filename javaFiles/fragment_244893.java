protected void getKeyStore(X509Certificate certificate)
{
    File newSnKeyStoreFile = new File("Mypath..\\keyStore.jks");

    try {

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);

        if(!certificate.toString().isEmpty())