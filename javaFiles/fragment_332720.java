@Test
public void persistGenericModelsAsync() throws JsonProcessingException {

    //stubbed - but never used
    when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class), Mockito.eq(JsonNode.class))).thenReturn(response);

    //stubbed - but never used
    when(response.getHeaders()).thenReturn(headers);
    List<String> cookiesTest = Arrays.asList("TxCartIdtest", "test");
    //stubbed - but never used
    when(headers.get(ValueConstant.SET_COOKIE)).thenReturn(cookiesTest);
    //stubbed - but never used
    when(response.getBody()).thenReturn(jsonNode);
}