final ProxySelector proxySelector = new ProxySelector() {
    @Override
    public java.util.List<Proxy> select(final URI uri) {
        final List<Proxy> proxyList = new ArrayList<Proxy>(1);

        // Host
        final String host = uri.getHost();

        // Is an internal host
        if (host.startsWith("127.0.0.1") || StringUtils.contains(nonProxyHostsValue, host)) {
            proxyList.add(Proxy.NO_PROXY);
        } else {
            // Add proxy
            proxyList.add(new Proxy(Type.HTTP,
                    new InetSocketAddress(proxyHostNameValue, Integer.parseInt(proxyPortValue))));
        }

        return proxyList;
    }

    @Override
    public void connectFailed(URI arg0, SocketAddress arg1, IOException arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
};

// Set proxy selector
okHttpClientBuilder.proxySelector(proxySelector);