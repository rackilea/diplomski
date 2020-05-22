public class CustomProxySelector extends ProxySelector {

    private Configurator configurator = Configurator.getInstance();
    private List<String> nonProxyHosts = Arrays.asList(configurator.getNonProxyHosts().split("\\|"));
    private String proxyHost = configurator.getProxyHost();
    private int proxyPort = configurator.getProxyPort();

    @Override
    public List<Proxy> select(URI uri) {
        final List<Proxy> proxyList = new ArrayList<>(1);
        String host = uri.getHost();

        if (host.startsWith("127.0.0.1") || nonProxyHosts.contains(host))
            proxyList.add(Proxy.NO_PROXY);
        else
            proxyList.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));

        return proxyList;
    }

    @Override
    public void connectFailed(URI arg0, SocketAddress arg1, IOException arg2) {
    }
}