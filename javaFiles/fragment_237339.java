ArgumentCaptor<HttpEntity> requestEntity = ArgumentCaptor.forClass(HttpEntity.class);
Mockito.doNothing().when(httpPostSearchOrg).setEntity(requestEntity.capture());
when(client.execute(same(httpPostSearchOrg), any(ResponseHandler.class))).thenAnswer(new Answer<Object>() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            if (matchesEntityToReturnResponse1(requestEntity.getValue())) {
                return "RESPONSE1";
            } else {
                return "RESPONSE2";
            }
        }
    });