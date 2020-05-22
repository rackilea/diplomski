@Test
public void testServerUserRegister(TestContext context) {
  // Get an async object to control the completion of the test
  Async async = context.async();
  HttpClient client = vertx.createHttpClient();
  HttpClientRequest request = client.post("user/sign", response -> {
    // You may want to check response code here
    // to either complete or fail the test
    async.complete();
    System.out.println("Some callback " + response.statusCode());
  });

  String body = "{'username':'www','password':'www'}";
  request.putHeader("content-length", "1000");
  request.putHeader("content-type", "application/x-www-form-urlencoded");
  request.write(body);
  request.end();
}