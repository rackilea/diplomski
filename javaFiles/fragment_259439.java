...
String expectedPublicationId = "expectedPublicationId";
List<Object[]> searchDataPubService = new ArrayList<>();
searchData.add(new Object[]{expectedPublicationId, and the other expectedThingies});
Mockito.when(mockedRetrievePublicationService).getSearchData(any(String.class), any(String.class)).thenReturn(searchDataPubService ); <- we tell mockito here, it should return your list, for any call.

List<Map<String, Object>> searchData = classUnderTest.getSearchData(fromDate, toDate);

assertEquals(expectedPublicationId, searchData.get(0).get("publicationId")); ... since you map the [0]th entry from the object array to they key "publicationId" in the Map
... and the other assertions