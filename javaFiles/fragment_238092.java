public void opController(RoutingContext routingContext) {
        routingContext.request().bodyHandler(bodyHandler -> {
            JsonObject jso = bodyHandler.toJsonObject();
            System.out.println("Received json body as : " + jso.encodePrettily());
        });

        // Complete request
        routingContext.response().setStatusCode(200).end("Done!");
    }