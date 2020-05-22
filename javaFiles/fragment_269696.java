package de.scrum_master.stackoverflow.q58101434;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class MyRestApi {
  public HttpStatus api() throws URISyntaxException {
    //Code to call an API and i want to test this in groovy spock
    HttpHeaders httpHeaders = createHttpHeaders();
    RestTemplate restTemplate = createRestTemplate();
    String url ="url";
    String body ="body";
    //How to mock below line
    RequestEntity<String> requestEntity = createRequestEntity(url, body);
    //And this line
    ResponseEntity<String> responseEntity = executeRequest(restTemplate, requestEntity);
    return responseEntity.getStatusCode();
  }

  HttpHeaders createHttpHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    return httpHeaders;
  }

  RestTemplate createRestTemplate() {
    return new RestTemplate();
  }

  RequestEntity<String> createRequestEntity(String url, String body) throws URISyntaxException {
    return RequestEntity.put(new URI(url)).contentType(MediaType.APPLICATION_JSON).body(body);
  }

  ResponseEntity<String> executeRequest(RestTemplate restTemplate, RequestEntity<String> requestEntity) {
    return restTemplate.exchange(requestEntity,String.class);
  }
}