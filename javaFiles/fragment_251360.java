@Test
void addHeaderToRequest() {

    //given
    var query = "query";
    given(nutritionixHeader.getNutritionixAppId()).willReturn("x-app-id");
    given(nutritionixHeader.getNutritionixAppKey()).willReturn("x-app-key");

    //when
    restTemplateFacade.addHeaderToRequest(query);

    //then

    ArgumentCaptor<HttpEntity> httpEntityCapture = ArgumentCaptor.forClass(HttpEntity.class);
    String url = "https://trackapi.nutritionix.com/v2/search/instant?query=query";
    verify(restTemplate).exchange(eq(url), eq(HttpMethod.GET), httpEntityCapture.capture(), eq(Products.class));

    HttpHeaders headers = httpEntityCapture.getValue().getHeaders();

    assertEquals("x-app-id",
            headers.entrySet()
                    .stream()
                    .filter(entry -> entry.getKey().equals("x-app-id"))
                    .map(Map.Entry::getValue)
                    .flatMap(Collection::stream)
                    .findFirst()
                    .orElse(""));

    then(nutritionixHeader).should(times(1)).getNutritionixAppId();
}