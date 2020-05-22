TrustStrategy easyStrategy = new TrustStrategy() {
    public boolean isTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
        // eh, why not?
        return true;
    }
};
SSLSocketFactory sf = new SSLSocketFactory(easyStrategy);