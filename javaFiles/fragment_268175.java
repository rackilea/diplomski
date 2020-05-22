mWebServerComponent = new Component();
    mWebServerComponent.getClients().add(Protocol.FILE);
    mWebServerComponent.getServers().add(Protocol.HTTP, 8182);
    mWebServerComponent.getDefaultHost().attach(new FileApplication());
    try {
        mWebServerComponent.start();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }