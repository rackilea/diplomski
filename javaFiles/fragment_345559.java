public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    Router router = Router.router(vertx);

    router.get("/").handler((request) -> {
        // When hub receives request, it dispatches it to one of the Spokes
        String requestUUID = UUID.randomUUID().toString();
        vertx.eventBus().send("processMessage", requestUUID, (spokeResponse) -> {
            if (spokeResponse.succeeded()) {
                request.response().end("Request " + requestUUID + ":" + spokeResponse.result().body().toString());
            }
            // Handle errors
        });
    });

    // We create two Spokes
    vertx.deployVerticle(new SpokeVerticle());
    vertx.deployVerticle(new SpokeVerticle());

    // This is your Hub
    vertx.createHttpServer().requestHandler(router::accept).listen(8888);
}