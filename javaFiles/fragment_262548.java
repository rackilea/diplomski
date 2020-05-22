// Starting server BrowserMobProxy

    server= new BrowserMobProxyServer();
    server.setConnectTimeout(10, TimeUnit.SECONDS);
    server.start(8897);
    Proxy proxy = ClientUtil.createSeleniumProxy(server);