private RestTemplate restTemplate;

public byte[] getProfilePic(){
  String canonicalPath = "http://dockertest/bankingapp/customer/profpicFile";
  String sessionId= "MTQ4NzE5Mz...etc";
  List<HttpMessageConverter> converters = new ArrayList<>(1);
  converters.add(new ByteArrayHttpMessageConverter());
  restTemplate.setMessageConverters(converters);
  HttpEntity<byte[]> request = new HttpEntity<byte[]>(null, getHeaders(true, "GET", null, canonicalPath, sessionId));
  //getHeaders() will return HttpHeaders with those parameter

  ResponseEntity<byte[]> response = null;
  try {
    response = this.restTemplate.exchange(uri, HttpMethod.GET, request, byte[].class);
  } catch( HttpServerErrorException hse ){
    throw hse;
  }
  return response;
}