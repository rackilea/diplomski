@Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig()
            .dynamicPort()
            .dynamicHttpsPort()
            .keystorePath(certsDir.resolve("server.jks").toString())
            .keystorePassword(MY_PASS)
            .keystoreType("JKS")
    );