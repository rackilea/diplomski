public class Foo {
    // I'm just returning something, not sure how your implementation is (and it doesn't make difference because you'll mock it anyway)
    public static SSLContext getSslContext() {
        try {
            return SSLContext.getDefault();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    // I'm just returning something, not sure how your implementation is (and it doesn't make difference because you'll mock it anyway)
    public static HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {

            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        };
    }
}