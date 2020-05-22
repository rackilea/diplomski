if(System.getProperty("os.name").toLowerCase().contains("windows")) {
    try {
        KeyStore ks = KeyStore.getInstance("Windows-ROOT");
        ks.load(null, null);
        System.setProperty("javax.net.ssl.trustStoreType", "Windows-ROOT");
    } catch(Exception e) {
        // Ignore: windows keystore is bad, left default
    }
}