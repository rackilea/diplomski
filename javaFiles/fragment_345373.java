InputStream jsonResponse = createJsonResponse();
    // Define expected calls.
    Mockito.when(mHttpClientMock.execute(Mockito.isA(HttpPost.class))).thenReturn(mHttpResponseMock);
    Mockito.when(mHttpResponseMock.getStatusLine()).thenReturn(mStatusLineMock);
    Mockito.when(mStatusLineMock.getStatusCode()).thenReturn(HttpStatus.SC_OK);
    Mockito.when(mHttpResponseMock.getEntity()).thenReturn(mHttpEntityMock);
    Mockito.when(mHttpEntityMock.getContent()).thenReturn(jsonResponse);