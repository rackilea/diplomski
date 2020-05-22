System.setProperty("java.net.useSystemProxies", "true");
System.out.println("detecting proxies");
List l = null;
try {
    l = ProxySelector.getDefault().select(new URI("http://foo/bar"));
} 
catch (URISyntaxException e) {
    e.printStackTrace();
}
if (l != null) {
    for (Iterator iter = l.iterator(); iter.hasNext();) {
        java.net.Proxy proxy = (java.net.Proxy) iter.next();
        System.out.println("proxy type: " + proxy.type());

        InetSocketAddress addr = (InetSocketAddress) proxy.address();

        if (addr == null) {
            System.out.println("No Proxy");
        } else {
            System.out.println("proxy hostname: " + addr.getHostName());
            System.setProperty("http.proxyHost", addr.getHostName());
            System.out.println("proxy port: " + addr.getPort());
            System.setProperty("http.proxyPort", Integer.toString(addr.getPort()));
        }
    }
}