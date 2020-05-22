if (DB_SSL || SSL) {
            System.setProperty("javax.net.ssl.keyStore", KEYSTORE);
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);
            System.setProperty("javax.net.ssl.trustStore", KEYSTORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);
        if (DEBUG_OPTION) {
            System.setProperty("javax.net.debug", "true");
        }
    }

private static String KEYSTORE = "/home/me/.keystore";
private static String KEYSTORE_PASS = "changeit";