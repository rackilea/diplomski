ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
RestTemplate restTemplate = new RestTemplate(requestFactory);

HttpEntity<String> request = new HttpEntity<>(new String("<user_id_value>"));
String userId = restTemplate.postForObject("http://demo2.com"+"/doLogout", request, String.class);
System.out.println("User ID : " + userId);