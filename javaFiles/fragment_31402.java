ProxySelector.setDefault(new ProxySelector() {

        @Override
        public List<Proxy> select(URI uri) {
            ArrayList<Proxy> list = new ArrayList<Proxy>(); 
            list.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy1.de", 8000)));
            list.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy2.de", 8080)));
            return list;
        }

        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            logger.error("Error in ProxySelector, connection Failed: ", ioe);
        }
    });