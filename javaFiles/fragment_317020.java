@Test
public void checkFilterDataControllerInvalidBodyResponse() {
    String servicePath = getBaseUrl() + "/statistics/filters?startDate={startDate}&endDate={endDate}";
    TestRestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(servicePath, String.class, "", "");
    assertThat(response, notNullValue());
    assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
}