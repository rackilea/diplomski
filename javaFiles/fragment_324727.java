@Mocked
RestTemplate restTemplate;

new NonStrictExpectations() {
    {
      new RestTemplate();
      result = restTemplate; 
      restTemplate.exchange(host, HttpMethod.GET, entity, String.class);
      returns(new ResponseEntity<String>("success", HttpStatus.OK));
    }