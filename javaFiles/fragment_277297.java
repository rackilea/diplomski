public void tryme() throws ClientProtocolException, IOException {
 String urlOverHttps = "https:xxxxxxx";  
 CloseableHttpClient httpClient = 
      HttpClients.custom()
             .setSSLHostnameVerifier(new NoopHostnameVerifier())
             .build();
   HttpComponentsClientHttpRequestFactory reqFactory = 
              new HttpComponentsClientHttpRequestFactory();
   reqFactory.setHttpClient(httpClient);

   ResponseEntity<String> response =  
          new RestTemplate(reqFactory).exchange(
                  urlOverHttps, HttpMethod.GET, null, String.class);
   String responseCode = response.getStatusCode();
}