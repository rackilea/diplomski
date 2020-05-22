@Test(expected = IllegalStateException.class)
public void testConnectToFTPServer_InvalidUserPassword() throws Exception {
    // assuming you already started it in setup(), you may want to stop it first
    if (server.isStarted()) {
        server.stop();
    }

    ConnectCommandHandler connectCommandHandler = (ConnectCommandHandler) server.getCommandHandler(CommandNames.CONNECT);

    // 430 = FTP error code for "Invalid username or password"
    connectCommandHandler.setReplyCode(430);
    server.setCommandHandler(CommandNames.CONNECT, connectCommandHandler);
    server.start();

    service.connectToFTPServer("testdomain.org", controllerPort);
}