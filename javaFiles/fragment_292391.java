@Test(timeout = 5000)
public void testConnectToFTPServer_InvalidHostName() throws Exception {
    // assuming you already started it in setup(), you may want to stop it first
    if (server.isStarted()) {
        server.stop();
    }

    ConnectCommandHandler connectCommandHandler = (ConnectCommandHandler) server.getCommandHandler(CommandNames.CONNECT);

    // 10060 = FTP error code for "Cannot connect to remote server."
    connectCommandHandler.setReplyCode(10060);
    server.setCommandHandler(CommandNames.CONNECT, connectCommandHandler);
    server.start();

    service.connectToFTPServer("testdomain.org", controllerPort);
}