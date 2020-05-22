Vertx vertx = Vertx.vertx();

    String url = "api.openweathermap.org";
    WebClient client = WebClient.create(vertx, new WebClientOptions().setDefaultPort(80).setDefaultHost(url));
    client.get("/data/2.5/weather?q=london,uk&units=metric&appid=e38f373567e83d2ba1b6928384435689").as(BodyCodec.string()).send(ar -> {
        if(ar.succeeded()) {
            HttpResponse<String> response = ar.result();
            System.out.println("Got HTTP response body");
            System.out.println(response.body());
        }
        else {
            ar.cause().printStackTrace();
        }
    });