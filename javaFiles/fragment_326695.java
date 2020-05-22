@Before
public void setUp(TestContext context) throws Exception {
    ServerSocket socket = new ServerSocket(0);
    port = socket.getLocalPort();
    socket.close();

    DeploymentOptions options = new DeploymentOptions()
            .setConfig(new JsonObject().put("http.port", port)
            );
    vertx = Vertx.vertx();
    vertx.deployVerticle(HelloVerticle.class.getName(), options,
            context.asyncAssertSuccess());
}
...

@Repeat(100)
@Test
public void testMyApplication(TestContext context) {

    final Async async = context.async();
    vertx.createHttpClient().getNow(port, "localhost", "/",
            response -> {
                response.handler(body -> {
                    context.assertTrue(body.toString().contains("Hello"));
                    context.assertEquals(200, response.statusCode());
                    async.complete();
                });
            });
}