package media.alu.jetty;
/**
 * SslContextFactoryRelaxed is used to configure SSL connectors
 * as well as HttpClient. It holds all SSL parameters and
 * creates SSL context based on these parameters to be
 * used by the SSL connectors.
 *
 * TrustAll really means trustAll!
 */
@ManagedObject
public class SslContextFactoryRelaxed extends SslContextFactory
{
    private String _keyManagerFactoryAlgorithm = DEFAULT_KEYMANAGERFACTORY_ALGORITHM;
    private String _trustManagerFactoryAlgorithm = DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM;

    @Override
    protected TrustManager[] getTrustManagers(KeyStore trustStore, Collection<? extends CRL> crls) throws Exception
    {
        TrustManager[] managers = null;
        if (trustStore != null)
        {
            if (isTrustAll()) {
                managers = TRUST_ALL_CERTS;
            }

            // Revocation checking is only supported for PKIX algorithm
            else if (isValidatePeerCerts() && "PKIX".equalsIgnoreCase(getTrustManagerFactoryAlgorithm()))
            {
                PKIXBuilderParameters pbParams = newPKIXBuilderParameters(trustStore, crls);

                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(_trustManagerFactoryAlgorithm);
                trustManagerFactory.init(new CertPathTrustManagerParameters(pbParams));

                managers = trustManagerFactory.getTrustManagers();
            }
            else
            {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(_trustManagerFactoryAlgorithm);
                trustManagerFactory.init(trustStore);

                managers = trustManagerFactory.getTrustManagers();
            }
        }

        return managers;
    }

}