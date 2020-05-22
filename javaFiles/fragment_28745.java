...
        URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
            @Override
            public URLStreamHandler createURLStreamHandler(String protocol) {
                if (protocol.equals("http")) {
                    return new HttpHandler();
                } else if (protocol.equals("https")) {
                    return new sun.net.www.protocol.https.Handler();
                }
                return null;
            }
        });
        ...

private class HttpHandler extends java.net.URLStreamHandler {

    protected int getDefaultPort() {
        return 80;
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return openConnection(u, (Proxy) null);
    }

    @Override
    protected URLConnection openConnection(URL u, Proxy p) throws IOException {
        return new HttpURLConnection(u, p) {

            @Override
            protected HttpClient getNewHttpClient(URL url, Proxy p, int connectTimeout)
                    throws IOException {
                return new HttpClient(url, (String) null, -1, true, connectTimeout) {

                    @Override
                    protected Socket createSocket() throws IOException {
                        Socket s = new Socket();

                        s.bind(new InetSocketAddress(InetAddress.getByName("1.2.3.4"),
                                0)); // yours IP here

                        return s;
                    }

                };
            }

            @Override
            protected HttpClient getNewHttpClient(URL url, Proxy p, int connectTimeout,
                    boolean useCache) throws IOException {
                return getNewHttpClient(url, p, connectTimeout);
            }

        };
    }
}