public void testPost() throws Exception {
    //Arrange
    String expected = "{blbl}";
    ResponseEntity<String> response = new ResponseEntity(expected,  HttpStatus.OK);    

    RestTemplate mockRestTemplate = mock(RestTemplate.class);

    when(mockRestTemplate.exchange(eq(baseUrl), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class)))
        .thenReturn(response);

    RestAPI api = new RestAPI(mockRestTemplate);

    //Act
    HTTPResult res = api.post(baseUrl, expected);

    //Assert
    assertEquals(res.getResponseBody(), expected);
    assertEquals(res.getStatusCode(), HttpStatus.OK.value());
}