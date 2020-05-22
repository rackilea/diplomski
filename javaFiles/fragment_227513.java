LazyReact streamBuilder = new LazyReact(15,15);

streamBuilder.fromIterable(urlRequests)
      .filter(urlReq->!validateRequests.isWhitelisted(urlReq))
      .forEach(request -> {
           ContentDetectionClient.detectContent(request);
       });