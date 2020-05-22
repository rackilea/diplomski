class IgnoreClientUsageTrustManager extends X509TrustManager {
    private final X509TrustManager origTrustManager;
    public class IgnoreClientUsageTrustManager(X509TrustManager origTrustManager) {
        this.origTrustManager = origTrustManager;
    }

    public checkClientTrusted(X509Certificate[] chain, String authType
        throws IllegalArgumentException, CertificateException {
        try {
            this.origTrustManager.checkClientTrusted(chain, authType);
        } catch (ValidatorException e) {
             // Check it's that very exception, otherwise, re-throw.
        }
    }

    // delegate the other methods to the origTrustManager
}