Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.post("/").handler(c -> {
            JsonObject json = c.getBodyAsJson();
            // If you want to read JSON array, use this
            // JsonArray jsonArray = c.getBodyAsJsonArray();

            c.response().end(json.toString());
        }
    );
    vertx.createHttpServer().requestHandler(router::accept).listen(8443);


    System.out.println("Server started");
    WebClient client = WebClient.create(vertx);

    // This will succeed
    client.request(HttpMethod.POST, 8443, "localhost", "/").
            sendBuffer(Buffer.buffer("{}"), h -> {
                System.out.println(h.result().bodyAsString());
            });

    // This will fail
    client.request(HttpMethod.POST, 8443, "localhost", "/").
            sendBuffer(Buffer.buffer("[]"), h -> {
                System.out.println(h.result().bodyAsString());
    });