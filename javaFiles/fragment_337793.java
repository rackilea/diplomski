@Bean
public RestTemplate restTemplate(){
    RestTemplate rest = new RestTemplate();
    ClientHttpRequestInterceptor interceptor= new SpringSessionClientHttpRequestInterceptor();
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
    interceptors.add(interceptor);
    rest.setInterceptors(interceptors);  
    return rest;
}