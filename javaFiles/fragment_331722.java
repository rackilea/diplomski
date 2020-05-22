private SSLSocketFactory originalSocketFactory;
private SSLSocketFactory customSocketFactory;

public void doSomeStuff(){

    try {
        setSocketFactories();
    } catch (CertificateException | IOException | GeneralSecurityException e) {
        e.printStackTrace();
    }

    //do your stuff here

    resetOriginalSocketFactory();
}

private void setSocketFactories() throws CertificateException, IOException, GeneralSecurityException {

    String jksFile = "C:\\My.jks";
    String type = "JKS";
    String password="password";

    if(null == originalSocketFactory){
        originalSocketFactory= HttpsURLConnection.getDefaultSSLSocketFactory();         
    }
    if(null == customSocketFactory){
        customSocketFactory = getCustomSocketFactory(jksFile, type, password);
        HttpsURLConnection.setDefaultSSLSocketFactory(customSocketFactory);
    }
}

private void resetOriginalSocketFactory(){
    HttpsURLConnection.setDefaultSSLSocketFactory(originalSocketFactory);
}

private SSLSocketFactory getCustomSocketFactory(String keyStoreLocation, String keystoreType,String password) 
        throws CertificateException, IOException, GeneralSecurityException {
    SSLSocketFactory socketFactory = new SSLSocketFactoryGenerator(keyStoreLocation,keystoreType).getSSLSocketFactory(password);
    return socketFactory;
}