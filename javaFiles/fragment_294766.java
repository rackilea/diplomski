@AfterClass
    public static void tearDown() throws Exception {
        System.out.println("Integration tests completed. Tear down the server ...");
        if (server != null && server.isStarted()) {
            server.shutdownNow();
            System.out.println("Grizzly instance shutdown completed");
        }
    }