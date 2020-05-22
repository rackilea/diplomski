public <T> List<T> getEventList(String url, ParameterizedTypeReference<List<T>> ptr) {
  List<T> result = Collections.emptyList();
  ResponseEntity<List<T>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, ptr);
  if (responseEntity.hasBody()) {
    result = responseEntity.getBody();
  }

  return result;
}