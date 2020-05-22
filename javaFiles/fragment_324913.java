public  void connectAndLogin( {

    connect();
    login();

}

private void connect() {
    /**
     * Set server configuration
     * 
     * connect to server    
     */
    setConfiguration();
    try {
        getConnection().connect();
    } catch (XMPPException e) {
        e.printStackTrace();
        setConnection(null);
    }
    }

    private void setConfiguration() {
        ConnectionConfiguration config = new ConnectionConfiguration(Constants.IP);
        SmackConfiguration.setPacketReplyTimeout(Constants.PACKET_TIME_OUT);
        System.out.println(SmackConfiguration.getVersion());
        config.setRosterLoadedAtLogin(false);
        // config.setCompressionEnabled(true);
        config.setVerifyChainEnabled(false);
        config.setReconnectionAllowed(true);
        config.setSASLAuthenticationEnabled(false);
        config.setSecurityMode(SecurityMode.disabled);
        config.setDebuggerEnabled(false);
        connection = new XMPPConnection(config);
}

private void login() {
    if(getConnection()!=null){


    String USER_NAME="";

    String PASSWORD="";

    try {
        getConnection().login(USER_NAME,PASSWORD, Constants.RESOURCE);
    } catch (Exception e) {
        e.printStackTrace();
    }



    }
}