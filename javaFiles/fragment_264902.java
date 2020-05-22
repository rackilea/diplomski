KeyStore keyStore = null;
SSLConfig config = null;

try {
        keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(
                new FileInputStream("certs/client_cert_and_private.p12"),
                password.toCharArray());

    } catch (Exception ex) {
        System.out.println("Error while loading keystore >>>>>>>>>");
        ex.printStackTrace();
    }

    if (keyStore != null) {

        org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore, password);

        // set the config in rest assured
        config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();

RestAssured.config = RestAssured.config().sslConfig(config);
RestAssured.given().when().get("/path").then();