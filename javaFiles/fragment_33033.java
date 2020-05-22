KeyStore clientStore = KeyStore.getInstance("PKCS12");
    try {
        clientStore.load(ResourceUtils.getFile("classpath:keystore/file.p12"), "secret".toCharArray());
    } catch (IOException e) {
        //handle exception
    }

    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(clientStore, "secret".toCharArray());
    KeyManager[] kms = kmf.getKeyManagers();

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kms, null, new SecureRandom());

    SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

    HttpClientBuilder builder = HttpClientBuilder.create();
    return builder.setSSLSocketFactory(socketFactory).build();