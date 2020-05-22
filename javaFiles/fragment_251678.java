router.route().path("/user/admin").method(HttpMethod.POST)
        .handler(rct -> {

            HttpServerRequest request = rct.request().setExpectMultipart(true);

            request.pause(); // Here is to pasue the origin request.

            MultiMap headers = request.headers();

            JsonObject param = new JsonObject().put("requestUrl", "http://localhost:18080/authorize")
                    .put("httpMethod", "POST");

            webClient.postAbs("http://localhost:18080/authorize")
                    .timeout(6000)
                    .putHeader("Content-Type", "application/json")
                    .putHeader("Authorization", headers.get("Authorization"))
                    .as(BodyCodec.jsonObject())
                    .sendJsonObject(param, ar -> authHandler(rct, ar));

        });