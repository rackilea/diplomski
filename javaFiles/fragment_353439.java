private void establishConnection(ProxyData proxyData, int connectTimeout, SocketAddress sourceAddress) throws IOException
{
    /* See the comment for createInetAddress() */

    if (proxyData == null)
    {
        InetAddress addr = createInetAddress(hostname);
        //test
        if (sourceAddress != null) {
                            sock.bind(sourceAddress);
                        }
        sock.connect(new InetSocketAddress(addr, port), connectTimeout);
        sock.setSoTimeout(0);
        return;
    }

    if (proxyData instanceof HTTPProxyData)
    {
        HTTPProxyData pd = (HTTPProxyData) proxyData;

        /* At the moment, we only support HTTP proxies */

        InetAddress addr = createInetAddress(pd.proxyHost);
        //test
        if (sourceAddress != null) {
                            sock.bind(sourceAddress);
                        }
        sock.connect(new InetSocketAddress(addr, pd.proxyPort), connectTimeout);
        sock.setSoTimeout(0);