RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Employee>> response = restTemplate.exchange(
      "http://localhost:8080/employees/",
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<Employee>>(){});
      List<Employee> employees = response.getBody();