public class TrustAllStrategy implements TrustStrategy {
/**
 * Implement strategy to always trust certificates.
 * @see {org.apache.http.ssl.TrustStrategy} TrustStrategy
 */
@Override
public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    return true;
}

}