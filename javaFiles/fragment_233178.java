public static void main(String[] args) throws Exception
{
    HttpClient client = new HttpClientConf()
        .sslContext(new SslConf().trustAll().createContext()) // trust self-signed certs
        .sslEngineConf(engine -> disableHostNameVerification(engine))
        .trafficDump(System.out::print)
        .newClient();
    // typically, app creates one client and use it for all requests

    String url = "https://ns6.host.md:8443/sitepreview/http/zugo.md/media/images/thumb/23812__yu400x250.jpg";
    HttpResponse response = client.doGet(url).sync();
    ByteBuffer bb = response.bodyBytes(Integer.MAX_VALUE).sync();

    InputStream is = new ByteArrayInputStream(bb.array(), bb.arrayOffset()+bb.position(), bb.remaining());
    BufferedImage image = ImageIO.read(is);

}

static void disableHostNameVerification(SSLEngine engine)
{
    SSLParameters sslParameters = engine.getSSLParameters();
    {
        // by default, it's set to "HTTPS", and the server certificate must match the request host.
        // disable it for this example, since the server certificate is ill constructed.
        sslParameters.setEndpointIdentificationAlgorithm(null);
    }
    engine.setSSLParameters(sslParameters);
}