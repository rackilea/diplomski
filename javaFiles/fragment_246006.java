final String uri = "http://localhost:8080/MyServices/adduser";
String userid = "05580a6caa7244a6986ca834403f1a93";
String usertype = "buyer";
String username = "shivam42";
MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
params.add("userid", userid);
params.add("usertype", usertype);
params.add("username", username);

RestTemplate restTemplate = new RestTemplate();
HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
messageConverters.add(stringHttpMessageConverternew);
messageConverters.add(formHttpMessageConverter);
restTemplate.setMessageConverters(messageConverters);
System.out.println(restTemplate.postForObject(uri, params, String.class));