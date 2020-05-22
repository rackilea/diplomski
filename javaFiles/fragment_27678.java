Observable request1 = getRequest1();
Observable request2 = getRequest2();

Observable.zip(request1, request2,
  new BiFunction<Something, Something, Pair<Something, Something>() {
    @Override
    public Pair<Something, Something> apply(Something response1, Something response2) {
      return new Pair(response1, response2); // you can create a custom object to handle all of the responses
    }
  })
  .map( // do something with your responses )