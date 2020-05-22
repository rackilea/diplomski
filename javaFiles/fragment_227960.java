public class SslConfig {

@Value("${ocp.http-client.certificate}")
private  String certificate;

private final static String certificateType = "X.509";
private final static String alias = "root";

private static SslContext sslContext;

public  WebClient getSslWebClient (){

    try {

        sslContext = getSslContext();

    } catch (Exception e) {

        e.printStackTrace();
    }
    SslContext finalSslContext = sslContext;
    TcpClient tcpClient = TcpClient.create().secure(sslContextSpec -> sslContextSpec.sslContext(finalSslContext));
    HttpClient httpClient = HttpClient.from(tcpClient);
    ClientHttpConnector httpConnector = new ReactorClientHttpConnector(httpClient);

    return WebClient.builder().clientConnector(httpConnector).build();
}

//Se configura el contexto sobre el cual se trabajara la comunicacion SSL
public  SslContext getSslContext(){

    try {
        ByteArrayInputStream is = new ByteArrayInputStream(certificate.getBytes());
        final KeyStore keyStore = readKeyStore(is);

        X509Certificate[] trusted = Collections.list(keyStore.aliases()).stream().map(alias -> {
            try {
                return (X509Certificate) keyStore.getCertificate(alias);
            } catch (KeyStoreException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);

            }
        }).toArray(X509Certificate[]::new);
        sslContext = SslContextBuilder.forClient().trustManager(trusted).build();
    }catch (GeneralSecurityException | SSLException e ){
        System.out.println(e.getMessage());
        throw new RuntimeException(e);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return sslContext;
}

private static KeyStore readKeyStore(InputStream is) throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException {

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
    CertificateFactory cf = CertificateFactory.getInstance(certificateType);
    Certificate cert = null;
    while (is.available() > 0) {
        cert = cf.generateCertificate(is);
    }
    ks.setCertificateEntry(alias, cert);
    return ks;
}
}