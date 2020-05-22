vertx.eventBus().consumer("test-bus", (Message<A> message) -> {
     syncClient.sendRequest(requestId, file, message);
     Mockito.verify(httpClientRequest, Mockito.times(1)).handler(requestCaptor.capture());
     Handler<HttpClientResponse> httpClientResponseHandler = requestCaptor.getValue();
     httpClientResponseHandler.handle(httpClientResponse);
  });