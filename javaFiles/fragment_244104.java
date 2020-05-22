MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
headers.add("Authorization", "Basic " + base64Creds);
headers.add("Content-Type", "application/json");

RestTemplate restTemplate = new RestTemplate();
restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

HttpEntity<ObjectToPass> request = new HttpEntity<ObjectToPass>(objectToPassInstance, headers);

restTemplate.postForObject(urlPost, request, Boolean.class);