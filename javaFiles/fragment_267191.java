static Proxy getProxy() throws IOException {
    Properties proxyProperties = new Properties();
    InputStream inputStream = null;
    try {
        inputStream = Hello.getClass().getClassLoader().getResourceAsStream("proxy.properties");
        proxyProperties.load(inputStream);
    } finally {
        if(inputStream != null) {
            try {
                inputStream.close();
            } catch(IOException ioe) {
            }
        }
    }
    String proxyHost = proxyProperties.getProperty("http.proxyHost");
    if(proxyHost != null && proxyHost.length() > 0)) {
        String proxyPort = proxyProperties.getProperty("http.proxyPort");
        SocketAddress addr = new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort));
        return new Proxy(Proxy.Type.HTTP, addr);
    }
    return null;
}