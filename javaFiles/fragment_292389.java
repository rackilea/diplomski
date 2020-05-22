@Test(expected = IOException.class)
public void testConnectToFTPServer_ServerDown() throws Exception {
    // kill the server
    server.stop();
    service.connectToFTPServer("testdomain.org", controllerPort);
}