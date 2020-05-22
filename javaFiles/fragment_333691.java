protected static RequestSpecification configureRestAssured() {
    // Create the ReqSpec instance:
    RequestSpecification reqSpecToBuild = new RequestSpecBuilder().build();
    // Configure more simple stuff for common request specification:
    reqSpecToBuild
            .header("Content-Type", "application/json")
            .baseUri(envConf.getBaseURI())
            .config(getRAconfig());
    return reqSpecToBuild; 
    }
// Add extended config object to the request spec:
private static RestAssuredConfig getRAconfig() {
    // Create a special socket with our keystore and ALLOW_ALL_HOSTNAME_VERIFIER:
    SSLSocketFactory sslSocket = getSSLsocket (envConf.getKeystoreFile(), somePass, somePass);
    // Create a configuration instance to load into the request spec via config():
    RestAssuredConfig raConfigToBuild = RestAssuredConfig.config()
            // Set SSL configuration into the RA configuration, with an SSLConfig object, that refers to our socket:
            .sslConfig(SSLConfig.sslConfig().sslSocketFactory(sslSocket));
    return raConfigToBuild;
}
private static SSLSocketFactory getSSLsocket(String ksPath, String ksPassword, String pkPassword) {
    KeyStore keystore = KeyStore.getInstance("PKCS12");
    // Load keystore file and password:
    keystore.load(new FileInputStream(ksPath), ksPassword.toCharArray());
    SSLContext context = SSLContexts.custom()
            .loadKeyMaterial(keystore, pkPassword.toCharArray())
            .build();
    // This is the holy grail:
    SSLSocketFactory sslSocketToBuild = new SSLSocketFactory(context, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    return sslSocketToBuild;
}
}