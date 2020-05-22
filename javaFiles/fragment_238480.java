@Test
public void serverIsStarted(TestContext context) {
    final Async async = context.async(); // <-- create the Async instance

    vertx.createHttpClient().getNow(8080, "localhost", "/inexistent", response -> {
        context.assertEquals(200, response.statusCode());

        async.complete();  // <-- signal this test can now terminate
    });
}