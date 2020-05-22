package foo.bar.runnable;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import foo.bar.services.CustomSSLHttpClientFactory;

public class RunTestHttpClient
{
    private static String   urlSitoA           = "https://nbk196.addvalue.it";

    private static String   urlSitoB           = "https://nbk196b.addvalue.it";

    private static String   trustStoreFilePath = "truststore.jks";

    private static String   trustStorePassword = "P@ssw0rd";

    private static String[] allowedProtocols   =
                                               { "TLSv1" };

    public static void main(String[] args)
    {
        System.out.println("########## Test multy call with different cert in same keystore #############");
        System.out.println(" ----- ----- CASE OK ----- ----- ");
        testLogic("keystore.jks", "keystore.jks", "P@ssw0rd", null, "site_a", "site_b");
        System.out.println(" ----- ----- CASE KO ----- ----- ");
        System.out.println("########## Test multy call with different keystore #############");
        System.out.println(" ----- ----- CASE OK ----- ----- ");
        testLogic("site_a.pfx", "site_b.pfx", "P@ssw0rd", "pkcs12", null, null);
        System.out.println(" ----- ----- CASE KO ----- ----- ");
        testLogic("site_b.pfx", "site_a.pfx", "P@ssw0rd", "pkcs12", null, null);
    }

    private static void testLogic(String keyStoreFilePathA,
                                  String keyStoreFilePathB,
                                  String keyStorePassword,
                                  String keyStoreType,
                                  String certAliasSitoA,
                                  String certAliasSitoB)
    {
        Resource keyStoreFileA = new ClassPathResource(keyStoreFilePathA);
        Resource keyStoreFileB = new ClassPathResource(keyStoreFilePathB);

        Resource trustStoreFile = new ClassPathResource(trustStoreFilePath);

        CustomSSLHttpClientFactory clientFactorySitoA = new CustomSSLHttpClientFactory(keyStoreFileA, keyStorePassword, keyStoreType, trustStoreFile, trustStorePassword, allowedProtocols, certAliasSitoA);
        CustomSSLHttpClientFactory clientFactorySitoB = new CustomSSLHttpClientFactory(keyStoreFileB, keyStorePassword, keyStoreType, trustStoreFile, trustStorePassword, allowedProtocols, certAliasSitoB);

        try
        {
            CloseableHttpClient httpClientSitoA = clientFactorySitoA.getObject();

            HttpGet httpgetSitoA = new HttpGet(urlSitoA);

            try (CloseableHttpResponse responseSitoA = httpClientSitoA.execute(httpgetSitoA))
            {
                HttpEntity entitySitoA = responseSitoA.getEntity();

                System.out.println("------------------ SitoA ----------------------");
                System.out.println(responseSitoA.getStatusLine());
                if ( entitySitoA != null )
                {
                    System.out.println("Response content length: " + entitySitoA.getContentLength());
                    System.out.printf(EntityUtils.toString(entitySitoA));
                }
                EntityUtils.consume(entitySitoA);
            }

            System.out.println();
        }
        catch ( Exception e )
        {
            e.printStackTrace(System.out);
        }

        try
        {
            CloseableHttpClient httpClientSitoB = clientFactorySitoB.getObject();

            HttpGet httpgetSitoB = new HttpGet(urlSitoB);

            try (CloseableHttpResponse responseSitoB = httpClientSitoB.execute(httpgetSitoB))
            {
                HttpEntity entitySitoB = responseSitoB.getEntity();

                System.out.println("------------------ SitoB ----------------------");
                System.out.println(responseSitoB.getStatusLine());
                if ( entitySitoB != null )
                {
                    System.out.println("Response content length: " + entitySitoB.getContentLength());
                    System.out.printf(EntityUtils.toString(entitySitoB));
                }
                EntityUtils.consume(entitySitoB);
            }
            System.out.println();
        }
        catch ( Exception e )
        {
            e.printStackTrace(System.out);
        }
    }
}