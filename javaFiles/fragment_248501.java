public class MyTrustManager implements X509TrustManager {
private X509TrustManager defaultTrustManager;
private X509TrustManager myTrustManager;
private X509Certificate[] acceptedIssuers;

public MyTrustManager(Context context) throws KeyStoreException,
        NoSuchAlgorithmException, CertificateException, IOException {
    defaultTrustManager = getDefaultManager();
    myTrustManager = getLocalManager(context);
    if (defaultTrustManager == null || myTrustManager == null) {
        throw new IOException("Couldn't load X509TrustManager");
    }
    ArrayList<X509Certificate> acceptedIssuersList = new ArrayList<X509Certificate>();
    this.addToAccepted(acceptedIssuersList, defaultTrustManager);
    this.addToAccepted(acceptedIssuersList, myTrustManager);
    acceptedIssuers = acceptedIssuersList
            .toArray(new X509Certificate[acceptedIssuersList.size()]);
}

private void addToAccepted(
        ArrayList<X509Certificate> x509Certificates,
        X509TrustManager x509TrustManager) {
    for (X509Certificate x509Certificate : x509TrustManager
            .getAcceptedIssuers()) {
        x509Certificates.add(x509Certificate);
    }
}

private X509TrustManager getX509TrustManager(
        TrustManagerFactory trustManagerFactory) {
    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
    for (TrustManager trustManager : trustManagers) {
        if (trustManager instanceof X509TrustManager) {
            return (X509TrustManager) trustManager;
        }
    }
    return null;
}

private X509TrustManager getDefaultManager() throws KeyStoreException,
        NoSuchAlgorithmException {
    TrustManagerFactory trustManagerFactory = TrustManagerFactory
            .getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init((KeyStore) null);
    return getX509TrustManager(trustManagerFactory);
}

private X509TrustManager getLocalManager(Context context)
        throws CertificateException, NoSuchAlgorithmException,
        KeyStoreException, IOException {
    if (context == null) {
        return null;
    }
    InputStream inputStream = context
            .getResources().openRawResource(
                    R.raw.ca);
    CertificateFactory certificateFactory = CertificateFactory
            .getInstance("X.509");
    X509Certificate x509Certificate = (X509Certificate) certificateFactory
            .generateCertificate(inputStream);
    TrustManagerFactory trustManagerFactory = TrustManagerFactory
            .getInstance(TrustManagerFactory.getDefaultAlgorithm());
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    keyStore.load(null);
    keyStore.setCertificateEntry("ca", x509Certificate);
    trustManagerFactory.init(keyStore);
    return getX509TrustManager(trustManagerFactory);
}

@Override
public void checkClientTrusted(X509Certificate[] ax509certificate, String s)
        throws CertificateException {
    // TODO Auto-generated method stub
    try {
        myTrustManager.checkClientTrusted(ax509certificate, s);
    } catch (CertificateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        defaultTrustManager.checkClientTrusted(ax509certificate, s);
    }
}

@Override
public void checkServerTrusted(X509Certificate[] ax509certificate, String s)
        throws CertificateException {
    // TODO Auto-generated method stub
    try {
        myTrustManager.checkServerTrusted(ax509certificate, s);
    } catch (CertificateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        defaultTrustManager.checkServerTrusted(ax509certificate, s);
    }
}

public X509Certificate[] getAcceptedIssuers() {
    // TODO Auto-generated method stub
    return acceptedIssuers;
}

}