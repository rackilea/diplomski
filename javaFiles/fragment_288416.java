FooEndPoint endPoint = new FooEndPoint();
// Keep a reference to this instance
endPoint.setUrl("url1");

RestAdapter.Builder builder = new RestAdapter.Builder();
    builder.setEndpoint(endPoint);

SomeApi api = builder.build().create(SomeApi.class);
api.getSomeDataFromUrl1();

// when needed you can update the url
endPoint.setUrl("url2");

api.getSomeDataFromUrl2();