private ClientHttpRequestFactory getClientHttpRequestFactory() {
NetworkInterface nif = NetworkInterface.getByName("sup0");
Enumeration<InetAddress> nifAddresses = nif.getInetAddresses();
RequestConfig config = RequestConfig.custom()
        .setLocalAddress(nifAddresses.nextElement()).build();

CloseableHttpClient client = HttpClientBuilder
  .create()
  .setDefaultRequestConfig(config)
  .build();
return new HttpComponentsClientHttpRequestFactory(client);