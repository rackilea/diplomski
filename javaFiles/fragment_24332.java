@Bean
    public RestTemplate restTemplateForEmployment(){
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = httpClientBuilder.build();

        HttpComponentsClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory(httpClient);
        rf.setConnectTimeout(1000);
        rf.setConnectionRequestTimeout(1000);
        rf.setReadTimeout(10000);

        return new RestTemplate(rf);
    }