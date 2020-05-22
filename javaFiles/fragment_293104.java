MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    RestTemplate restTemplate = new RestTemplate();

    headers.add("Authorization", "Basic " + Base64String);
    headers.add("Content-Type", "application/json");
    .
    .
    .

    HttpEntity<RaisEventRequest> request = new HttpEntity<RaisEventRequest>(RaisEventRequest, headers);

    ResponseEntity<RaisEventResponse> responseEntity = restTemplate
            .exchange(eventsURL, HttpMethod.POST, request, RaisEventResponse.class);

    return responseEntity.getBody();