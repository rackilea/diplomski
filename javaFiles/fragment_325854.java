private static void initConnnector(Server server, Configs configObj) {
    SelectChannelConnector connector = new SelectChannelConnector();

    //Don't set any host , or the port detection will failed. -_-#
    //connector.setHost("127.0.0.1");
    connector.setPort(configObj.getPort());

    if (configObj.getEnablessl() && configObj.getSslport() != null)
        connector.setConfidentialPort(configObj.getSslport());

    server.addConnector(connector);

    if (configObj.getEnablessl() && configObj.getSslport() != null)
        initSSL(server, configObj.getSslport(), configObj.getKeystore(),
                configObj.getPassword(), configObj.getKeyPassword(),
                configObj.getNeedClientAuth());

}