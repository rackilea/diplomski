KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
keyStore.load(new FileInputStream(new File("keystore.jks")),
        "secret".toCharArray());
SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
        new SSLContextBuilder()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                .loadKeyMaterial(keyStore, "password".toCharArray()).build());
HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
        httpClient);
RestTemplate restTemplate = new RestTemplate(requestFactory);
ResponseEntity<String> response = restTemplate.getForEntity(
        "https://localhost:8443", String.class);