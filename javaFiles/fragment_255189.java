public class HttpTest {

    static void processRemoteToLocal(String srcUrl, String destFile) throws Exception {
        URL fileUrl = new URL(srcUrl);

        HttpsURLConnection.setDefaultSSLSocketFactory(Foo.getSslContext().getSocketFactory());

        HttpsURLConnection.setDefaultHostnameVerifier(Foo.getHostnameVerifier());

        HttpsURLConnection connection = (HttpsURLConnection) fileUrl.openConnection();
    }
}